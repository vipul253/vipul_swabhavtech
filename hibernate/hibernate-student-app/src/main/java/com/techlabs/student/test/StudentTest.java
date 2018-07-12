package com.techlabs.student.test;

import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

import com.techlabs.student.Student;

public class StudentTest {

	private static Configuration conf = new Configuration();
	private static SessionFactory factory = conf.configure("hibernate.cfg.xml")
			.buildSessionFactory();

	public static void main(String[] args) {

		System.out.println(factory.getClass());

		Student student = new Student();
		student.setName("vip");
		student.setPointer(9.9);
		UUID uid = UUID.fromString("5e49a386-9b1b-48c3-89f1-2d2c9312ec25");
		addStudent(student);
		//update(uid);
		//delete(uid);
		//display();

	}

	public static void addStudent(Student student) {
		Session session = factory.openSession();
		Transaction txn = null;

		try {
			txn = session.beginTransaction();
			session.save(student);
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

	public static void display() {

		Session session = factory.openSession();
		Transaction txn = null;
		System.out.println(factory.getClass());
		try {
			txn = session.beginTransaction();

			List<Student> students = (List) session.createQuery("FROM Student")
					.list();
			for (Student s : students) {
				System.out.println(s.getName());
				System.out.println(s.getId());
			}

			UUID uid = UUID.fromString("8f9916db-d7fc-4211-9a0a-ab68cb7912d7");

			//Student s1 = (Student) session.get(Student.class, uid);

			//System.out.println(s1.getName());
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

	public static void update(UUID uid) {

		Session session = factory.openSession();
		Transaction txn = null;
		System.out.println(factory.getClass());
		try {
			txn = session.beginTransaction();
			Student s1 = (Student) session.get(Student.class, uid);

			s1.setName("newName");
			session.save(s1);

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

	public static void delete(UUID uid) {
		Session session = factory.openSession();
		Transaction txn = null;
		System.out.println(factory.getClass());
		try {

			txn = session.beginTransaction();
			Student s1 = (Student) session.get(Student.class, uid);

			session.delete(s1);
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
}
