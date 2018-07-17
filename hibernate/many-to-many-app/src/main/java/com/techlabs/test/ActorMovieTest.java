package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techlabs.actor.Actor;
import com.techlabs.actor.Movie;
import com.techlabs.customer.Customer;
import com.techlabs.customer.Service;

public class ActorMovieTest {
	private static Configuration conf = new Configuration();
	private static SessionFactory factory = conf.configure("hibernate.cfg.xml")
			.buildSessionFactory();

	public static void main(String[] args) {
		Session session = factory.openSession();
		Transaction txn = null;
		
		Actor a1 = createActor("morgan freeman");
		Actor a2 = createActor("leonardo dicaprio");
		Actor a3 = createActor("Robert Downey");
		
		
		Movie m1 = createMovie("Inception");
		Movie m2 = createMovie("Invictus");
		Movie m3 = createMovie("Sherlock Holmes");
		Movie m4 = createMovie("Iron Man");
		
		a1.addMovie(m2);
		a2.addMovie(m1);
		a3.addMovie(m3);
		a3.addMovie(m4);
		
		try {

			txn = session.beginTransaction();
			session.persist(a1);
			session.persist(a2);
			session.persist(a3);
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
	
	public static Actor createActor(String name) {
		Actor a = new Actor();
		a.setName(name);
		return a;
	}

	public static Movie createMovie(String name) {
		Movie m = new Movie();
		m.setName(name);
		return m;
	}
}
