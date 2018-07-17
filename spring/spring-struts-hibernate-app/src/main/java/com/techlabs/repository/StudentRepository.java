package com.techlabs.repository;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Student;
import com.techlabs.view.model.AddView;
import com.techlabs.view.model.EditView;

@Repository
public class StudentRepository {

	@Autowired
	private SessionFactory factory;
	private Session session = null;
	private Transaction txn = null;

	private List<Student> students = new ArrayList<>();

	public List<Student> get() {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			students = (ArrayList<Student>) criteria.list();
			txn.commit();
		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return students;
	}

	public void add(AddView add) {
		Student s = new Student(add.getFirstName(), add.getLastName(),
				add.getAddress());
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			session.save(s);
			txn.commit();
		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void edit(EditView edit) {
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Student s = (Student) session.get(Student.class, edit.getId());
			s.setFirstName(edit.getFirstName());
			s.setLastName(edit.getLastName());
			s.setAddress(edit.getAddress());
			txn.commit();
		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(int id) {
		System.out.println(id);
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Student s = (Student) session.get(Student.class, id);
			session.delete(s);
			txn.commit();
		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public Student getById(int id) {
		Student s = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			s = (Student) session.get(Student.class, id);
			txn.commit();
		} catch (HibernateException ex) {
			if (txn != null)
				txn.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return s;
	}
}
