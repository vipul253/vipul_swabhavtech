package com.shopping.cart.repository;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.cart.entity.Customer;
import com.shopping.cart.entity.Order;

@Repository
public class CustomerRepository {

	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;

	public boolean checkUser(String name, String password) {
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Customer where name=:n and password=:p");
			query.setParameter("n", name);
			query.setParameter("p",password);
			if(query.list().size()==1){
				return true;
			}
			
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	
	public void addOrder(String name, Order order){
		Customer cust = null;
		try {
			System.out.println("in checkout repo");
			session = factory.openSession();
			txn = session.beginTransaction();
			String hql = "from Customer c where c.name =:name";
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			cust = (Customer)query.uniqueResult();
			order.setCust(cust);
			cust.addOrder(order);
			session.save(cust);
			txn.commit();
			System.out.println("out of repo");
			
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
}
