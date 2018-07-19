package com.sample.bank.entity.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sample.bank.entity.Account;
import com.sample.bank.entity.User;

public class BankTest {
	private static Configuration conf = new Configuration();
	private static SessionFactory factory = conf.configure("hibernate.cfg.xml")
			.buildSessionFactory();
	
	
	public static void main(String[] args) {
		Session session = null;
		Transaction txn = null;
		
		User user = new User("vipul","123");
		Account a1 = new Account();
		com.sample.bank.entity.Transaction t = new com.sample.bank.entity.Transaction();
		Set<com.sample.bank.entity.Transaction> transactions = new HashSet<>();
		transactions.add(t);
		user.setAcc(a1);
		a1.setTxn(transactions);
		t.setAcc(a1);
		
		
		user.setRole("user");
		a1.setBalance(1234);
		user.setStatus("active");
		t.setType("D");
		t.setAmount(1234);
		
		User admin = new User("nieu","123");
		admin.setRole("admin");
		admin.setStatus("active");
		try {
			System.out.println("in repo");
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from User");
			System.out.println(query.list());
//			session.save(user);
//			session.save(admin);
			txn.commit();
			System.out.println("out of repo");
			
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
}
