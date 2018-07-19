package com.sample.bank.repository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.bank.entity.*;
import com.sample.bank.exceptions.InsufficientBalanceException;

@Repository
public class BankRepository {

	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;

	public void addAccount(User user) {
		com.sample.bank.entity.Transaction transaction = new com.sample.bank.entity.Transaction();
		transaction.setAcc(user.getAcc());
		transaction.setAmount(user.getAcc().getBalance());
		transaction.setType("D");
		user.getAcc().addTransaction(transaction);
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			session.save(user);
			txn.commit();

		} catch (HibernateException ex) {
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

	public String getRole(String name, String password) {
		String role = "";
		try {
			session = factory.openSession();
			Query query = session.createQuery("select role from User where name=:n and password=:p");
			query.setParameter("n", name);
			query.setParameter("p", password);
			role = query.uniqueResult().toString();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}

	public String getAccountStatus(String name, String password) {
		String accountStatus = "";
		try {
			session = factory.openSession();
			Query query = session.createQuery("select status from User where name=:n and password=:p");
			query.setParameter("n", name);
			query.setParameter("p", password);
			accountStatus = query.uniqueResult().toString();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return accountStatus;
	}

	public List<com.sample.bank.entity.Transaction> getTransactions(String name) {
		List<com.sample.bank.entity.Transaction> transactions = new ArrayList<com.sample.bank.entity.Transaction>();
		try {
			session = factory.openSession();
			Query getAccountQuery = session.createQuery("select acc from User where name=:n");
			getAccountQuery.setParameter("n", name);
			Account account = (Account) getAccountQuery.uniqueResult();
			Query query2 = session.createQuery("from Transaction where acc=:a");
			query2.setParameter("a", account);
			transactions = (ArrayList) query2.list();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return transactions;
	}

	public void makeTransaction(String name, com.sample.bank.entity.Transaction transaction)
			throws InsufficientBalanceException {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("select acc from User where name=:n");
			query.setParameter("n", name);
			Account account = (Account) query.uniqueResult();

			account.addTransaction(transaction);
			transaction.setAcc(account);
			if (transaction.getType().equals("W")) {
				if (account.getBalance() - transaction.getAmount() < 1000) {
					throw new InsufficientBalanceException("insufficent balance in account");
				}
				account.withdraw(transaction.getAmount());
			}
			if (transaction.getType().equals("D")) {
				account.deposit(transaction.getAmount());
			}
			session.save(account);
			txn.commit();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<User> getUsers() {
		List<User> users = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from User where role=:r");
			query.setParameter("r", "user");
			users = query.list();
		} catch (HibernateException ex) {
			txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	public void changeAccountState(UUID id) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where id=:id");
			query.setParameter("id", id);
			User user = (User) query.uniqueResult();
			if (user.getStatus().equals("active")) {
				user.setStatus("locked");
			} else {
				user.setStatus("active");
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
}
