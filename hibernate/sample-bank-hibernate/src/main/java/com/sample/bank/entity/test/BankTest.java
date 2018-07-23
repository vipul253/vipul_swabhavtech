package com.sample.bank.entity.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sample.bank.entity.Account;
import com.sample.bank.entity.AccountType;
import com.sample.bank.entity.Appointment;
import com.sample.bank.entity.Gender;
import com.sample.bank.entity.Recipient;
import com.sample.bank.entity.TransactionType;
import com.sample.bank.entity.User;
import com.sample.bank.entity.UserDetails;
import com.sample.bank.entity.UserRole;

public class BankTest {
	
	private static Configuration conf = new Configuration();
	@SuppressWarnings("deprecation")
	private static SessionFactory factory = conf.configure("hibernate.cfg.xml").buildSessionFactory();
	static Session session = null;
	static Transaction txn = null;

	public static void main(String[] args) {

		User user = new User("vipul","abc@abc.com", "123");
		Account a1 = new Account();
		Account a2 = new Account();
		com.sample.bank.entity.Transaction t = new com.sample.bank.entity.Transaction();
		Set<com.sample.bank.entity.Transaction> transactions = new HashSet<>();
		Set<Account> accounts = new HashSet<>();
		transactions.add(t);

		accounts.add(a1);
		accounts.add(a2);

		a1.setUser(user);
		a2.setUser(user);

		a1.setAccountType(AccountType.SAVINGS);
		a2.setAccountType(AccountType.CURRENT);

		user.setRole(UserRole.USER);
		user.setAccounts(accounts);
		user.setActive(true);
		user.setValid(true);

		t.setAcc(a2);
		t.setAmount(1234);
		t.setTransactionType(TransactionType.DEPOSIT);

		a2.setTransactions(transactions);
		a2.setBalance(t.getAmount());
		Date dob=null;
		try {
			dob = new SimpleDateFormat("yyyy/MM/dd").parse("1996/03/25");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		UserDetails profile = new UserDetails("vipul","sawant",Gender.MALE,dob);
		Recipient rec = new Recipient();
		Date apnDate=null;
		try {
			apnDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2018/07/26 02:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Appointment appointment = new Appointment("for loan",apnDate);
		saveUser(user);
		setProfile(profile);
		setRecipient(rec);
		setAppointment(appointment);
		
		User admin = new User("admin","admin@bank.com","111");
		admin.setRole(UserRole.ADMIN);
		admin.setActive(true);
		admin.setValid(true);
		saveUser(admin);
		//User user2 = new User("new","xyz@abc.com","123");
		
		
	}

	public static void saveUser(User user) {
		try {
			System.out.println("in repo");
			session = factory.openSession();
			txn = session.beginTransaction();
			session.save(user);
			txn.commit();
			System.out.println("out of repo");
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void setRecipient(Recipient rec) {
		try {
			System.out.println("in repo");
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name='vipul'");
			User testuser = (User) query.uniqueResult();
			Set<Account> accs = testuser.getAccounts();
			Account ac = null;
			for (Account a : accs) {
				if (a.getAccountType().equals(AccountType.SAVINGS)) {
					rec.setAcc(a);
					ac = a;
				}
				if (a.getAccountType().equals(AccountType.CURRENT)) {
					rec.setRecipientID(a.getId());
				}
			}
			ac.addRecipient(rec);
			session.save(ac);
			txn.commit();
			System.out.println("out of repo");
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void setProfile(UserDetails profile) {
		try {
			System.out.println("in repo");
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name='vipul'");
			User testuser = (User) query.uniqueResult();
			profile.setUser(testuser);
			testuser.setProfile(profile);
			session.save(testuser);
			txn.commit();
			System.out.println("out of repo");
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void setAppointment(Appointment appointment) {
		try {
			System.out.println("in repo");
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User where name='vipul'");
			User testuser = (User) query.uniqueResult();
			appointment.setUser(testuser);
			testuser.addAppointment(appointment);
			session.save(testuser);
			txn.commit();
			System.out.println("out of repo");
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
}
