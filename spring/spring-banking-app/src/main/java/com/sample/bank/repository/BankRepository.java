package com.sample.bank.repository;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.bank.entity.*;

@Repository
public class BankRepository {
	
	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;
	
	public void makeDB(){
		
		try {
			System.out.println("in repo");
			session = factory.openSession();
			txn = session.beginTransaction();
			
			txn.commit();
			System.out.println("out of repo");
			
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}
