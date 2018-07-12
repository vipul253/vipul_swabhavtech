package com.techlabs.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techlabs.department.Department;
import com.techlabs.employee.Employee;

public class OneToManyTest {
	private static Configuration conf = new Configuration();
	private static SessionFactory factory = conf.configure("hibernate.cfg.xml")
			.buildSessionFactory();

	public static void main(String[] args) {
		
		Session session = factory.openSession();
		Transaction txn = null;
		
		Department dept1 = new Department();
		dept1.setName("IT");
		Set<Employee> employees = new HashSet<Employee>();
		
		Department dept2 = new Department();
		dept2.setName("comps");
		Set<Employee> emps = new HashSet<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setName("vipul");
		emp1.setDept(dept1);
		
		Employee emp2 = new Employee();
		emp2.setName("lucifer");
		emp2.setDept(dept1);
		
		Employee emp3 = new Employee();
		emp3.setName("alex");
		emp3.setDept(dept2);
		
		employees.add(emp1);
		employees.add(emp2);
		emps.add(emp3);
		dept1.setEmployees(employees);
		dept2.setEmployees(emps);
		
		
		
		try {
			txn = session.beginTransaction();
			session.save(dept1);
			session.save(dept2);
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
