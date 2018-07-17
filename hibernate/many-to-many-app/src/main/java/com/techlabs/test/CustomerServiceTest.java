package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techlabs.customer.Customer;
import com.techlabs.customer.Service;

public class CustomerServiceTest {
	private static Configuration conf = new Configuration();
	private static SessionFactory factory = conf.configure("hibernate.cfg.xml")
			.buildSessionFactory();

	public static void main(String[] args) {
		Session session = factory.openSession();
		Transaction txn = null;
		
		Customer c1 = createCustomer("vipul");
		Service s1 = createService("makeReport");
		
		Set<Service> services = new HashSet<>();
		Set<Customer> customers = new HashSet<>();
		
		services.add(s1);
		customers.add(c1);
		
		c1.setServices(services);
		
		try {

			txn = session.beginTransaction();
			session.persist(c1);
			txn.commit();

		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
	
	public static Customer createCustomer(String name) {
		Customer c = new Customer();
		c.setName(name);
		return c;
	}

	public static Service createService(String name) {
		Service s = new Service();
		s.setName(name);
		return s;
	}
}
