package com.bank.repository;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entity.User;
import com.bank.enums.UserRole;

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
			role = (UserRole)query.uniqueResult();
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
			isActive = (boolean)query.uniqueResult();
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
			if(user!=null) {
			user.setLoginAttempts(user.getLoginAttempts()+1);
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
			isValid = (boolean)query.uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return isValid;
	}
}
