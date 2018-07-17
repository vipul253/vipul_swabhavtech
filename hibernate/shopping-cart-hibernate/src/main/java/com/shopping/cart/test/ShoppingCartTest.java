package com.shopping.cart.test;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.cart.model.Customer;
import com.shopping.cart.model.LineItem;
import com.shopping.cart.model.Order;
import com.shopping.cart.model.Product;

public class ShoppingCartTest {
	private static Configuration conf = new Configuration();
	private static SessionFactory factory = conf.configure("hibernate.cfg.xml")
			.buildSessionFactory();

	public static void main(String[] args) {
		
		Customer c1 = createCustomer("vipul", "123");
		
		Product p1 = createProduct("iPhone", 66000.0, 10.0);
		Product p2 = createProduct("Galaxy S9", 60000.0, 10.0);
		Product p3 = createProduct("Google Pixel", 55000.0, 10.0);
		Session session = factory.openSession();
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			session.save(p1);
			session.save(p2);
			session.save(p3);
			session.save(c1);
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

	public static Customer getCustomer(String name) {
		Customer cust = null;
		Session session = factory.openSession();
		Transaction txn = null;
		try {

			txn = session.beginTransaction();

			String hql = "from Customer c where c.name =:name";
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			cust = (Customer) query.uniqueResult();
			System.out.println("Name:" + cust.getName());
			System.out.print(cust.getDetails());

			txn.commit();

		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cust;
	}
	
	public static Product getProduct(String name) {
		Product p = null;
		Session session = factory.openSession();
		Transaction txn = null;
		try {

			txn = session.beginTransaction();

			String hql = "from Product p where p.name =:name";
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			p = (Product) query.uniqueResult();

			txn.commit();

		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return p;
	}

	public static Product createProduct(String name, double cost,
			double discount) {
		Product p = new Product();
		p.setName(name);
		p.setCost(cost);
		p.setDiscount(discount);
		return p;
	}

	public static LineItem createLineItem(Product p, int quantity, Order ord) {
		LineItem li = new LineItem();
		li.setProduct(p);
		li.setQuantity(quantity);
		li.setOrder(ord);
		return li;
	}

	public static Customer createCustomer(String name, String pass) {
		Customer c1 = new Customer();
		c1.setName(name);
		c1.setPassword(pass);
		return c1;
	}
}