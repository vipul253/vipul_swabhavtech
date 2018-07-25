package com.bank.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.email.EmailTool;
import com.bank.entity.Account;
import com.bank.entity.User;
import com.bank.enums.UserRole;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.enums.AccountType;
import com.bank.enums.TransactionType;

@Repository
public class BankRepository {

	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;

	public void addAccount(User user) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			session.save(user);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public boolean checkUser(String name, String password) {
		try {
			session = factory.openSession();
			Query query = session.createQuery("select name from User where name=:n and password=:p");
			query.setParameter("n", name);
			query.setParameter("p", password);
			if (query.uniqueResult() != null) {
				return true;
			}

		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public UserRole getRole(String name, String password) {
		UserRole role = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select role from User where name=:n and password=:p");
			query.setParameter("n", name);
			query.setParameter("p", password);
			role = (UserRole) query.uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}

	public boolean getAccountState(String name, String password) {
		boolean isActive = false;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select isActive from User where name=:n and password=:p");
			query.setParameter("n", name);
			query.setParameter("p", password);
			isActive = (boolean) query.uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return isActive;
	}

	public void changeAccountState(String name) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:name");
			query.setParameter("name", name);
			User user = (User) query.uniqueResult();
			if (user.isActive()) {
				user.setActive(false);
			} else {
				user.setActive(true);
			}
			session.save(user);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void setLastLoggedIn(String name) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:name");
			query.setParameter("name", name);
			User user = (User) query.uniqueResult();
			user.setLastLogin(new Date());
			session.save(user);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void increaseAttempts(String name) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:name");
			query.setParameter("name", name);
			User user = (User) query.uniqueResult();
			if (user != null) {
				user.setLoginAttempts(user.getLoginAttempts() + 1);
				session.save(user);
			}
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void resetAttempts(String name) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:name");
			query.setParameter("name", name);
			User user = (User) query.uniqueResult();
			user.setLoginAttempts(0);
			session.save(user);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public int getAttempts(String name) {
		int attempts = 0;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:name");
			query.setParameter("name", name);
			User user = (User) query.uniqueResult();
			attempts = user.getLoginAttempts();
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return attempts;
	}

	public boolean checkValid(String name) {
		boolean isValid = false;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select isValid from User where name=:n");
			query.setParameter("n", name);
			isValid = (boolean) query.uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return isValid;
	}

	public void sendVerificationEmail(String name) throws AddressException, MessagingException {
		try {
			session = factory.openSession();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User user = (User) query.uniqueResult();
			EmailTool.sendEmail(user.getEmail(), "http://localhost:8080/banking-app/verify?id=" + user.getId());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void verify(UUID id) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where id=:id");
			query.setParameter("id", id);
			User user = (User) query.uniqueResult();
			user.setValid(true);
			user.setActive(true);
			session.save(user);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<com.bank.entity.Transaction> getAllTransactions(String name) {
		List<com.bank.entity.Transaction> transactions = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			transactions = new ArrayList<com.bank.entity.Transaction>();
			for (Account a : accs) {
				transactions.addAll(a.getTransactions());
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return transactions;
	}

	public List<com.bank.entity.Transaction> getTransactions(String name, AccountType type) {
		List<com.bank.entity.Transaction> transactions = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			transactions = new ArrayList<com.bank.entity.Transaction>();
			for (Account a : accs) {
				if (a.getAccountType().equals(type)) {
					transactions.addAll(a.getTransactions());
				}
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return transactions;
	}

	public Account getCurrentAccount(String name) {
		Account account = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			for (Account a : accs) {
				if (a.getAccountType().equals(AccountType.CURRENT)) {
					account = a;
				}
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return account;
	}

	public Account getSavingsAccount(String name) {
		Account account = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			for (Account a : accs) {
				if (a.getAccountType().equals(AccountType.SAVINGS)) {
					account = a;
				}
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return account;
	}

	public void makeCurrentAccount(String name, double amount) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			for (Account a : accs) {
				if (a.getAccountType().equals(AccountType.CURRENT)) {
					return;
				}
			}

			Account account = new Account();
			account.setAccountType(AccountType.CURRENT);
			account.setUser(testuser);
			account.setBalance(amount);
			com.bank.entity.Transaction transaction = new com.bank.entity.Transaction();
			transaction.setAcc(account);
			transaction.setAmount(amount);
			transaction.setTransactionType(TransactionType.DEPOSIT);
			account.addTransaction(transaction);
			session.save(account);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void makeSavingsAccount(String name, double amount) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			for (Account a : accs) {
				if (a.getAccountType().equals(AccountType.SAVINGS)) {
					return;
				}
			}

			Account account = new Account();
			account.setAccountType(AccountType.SAVINGS);
			account.setUser(testuser);
			account.setBalance(amount);
			com.bank.entity.Transaction transaction = new com.bank.entity.Transaction();
			transaction.setAcc(account);
			transaction.setAmount(amount);
			transaction.setTransactionType(TransactionType.DEPOSIT);
			account.addTransaction(transaction);
			session.save(account);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void makeTransaction(String name, com.bank.entity.Transaction transaction, AccountType accountType)
			throws InsufficientBalanceException {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			Account account = null;
			for (Account a : accs) {
				if (a.getAccountType().equals(accountType)) {
					account = a;
				}
			}
			transaction.setAcc(account);
			if (transaction.getTransactionType().equals(TransactionType.WITHDRAW)) {
				if (account.getBalance() - transaction.getAmount() < 1000) {
					throw new InsufficientBalanceException("insufficent balance in account");
				}
				account.withdraw(transaction.getAmount());
			}
			if (transaction.getTransactionType().equals(TransactionType.DEPOSIT)) {
				account.deposit(transaction.getAmount());
			}
			account.addTransaction(transaction);
			session.save(account);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void doTransfer(String name, double amount, AccountType accountType) throws InsufficientBalanceException {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name=:n");
			query.setParameter("n", name);
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			Account accountTo = null;
			Account accountFrom = null;
			for (Account a : accs) {
				if (a.getAccountType().equals(accountType)) {
					accountTo = a;
				}
				if(!a.getAccountType().equals(accountType)) {
					accountFrom = a;
				}
			}
			com.bank.entity.Transaction transaction1 = new com.bank.entity.Transaction(amount, TransactionType.WITHDRAW);
			if (accountFrom.getBalance() - transaction1.getAmount() < 1000) {
				throw new InsufficientBalanceException("insufficent balance in account");
			}
			accountFrom.withdraw(transaction1.getAmount());
			accountFrom.addTransaction(transaction1);
			transaction1.setAcc(accountFrom);
			
			com.bank.entity.Transaction transaction2 = new com.bank.entity.Transaction(amount, TransactionType.DEPOSIT);
			accountTo.deposit(transaction2.getAmount());
			accountTo.addTransaction(transaction2);
			transaction2.setAcc(accountTo);
			session.save(accountFrom);
			session.save(accountTo);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
}
