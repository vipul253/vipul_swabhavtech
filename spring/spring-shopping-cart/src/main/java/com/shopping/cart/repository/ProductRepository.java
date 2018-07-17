package com.shopping.cart.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.cart.entity.Product;

@Repository
public class ProductRepository {
	
	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;
	
	private List<Product> products = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public List<Product> get() {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Criteria criteria = session.createCriteria(Product.class);
			products = (ArrayList<Product>)criteria.list();
			txn.commit();
		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return products;
	}
	
	public Product getById(UUID id) {
		Product p = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			p = (Product) session.get(Product.class, id);
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
}
