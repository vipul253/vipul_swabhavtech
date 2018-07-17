package com.techlabs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techlabs.service.StudentService;

public class StudentTest {
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService svc1 = context.getBean("StudentSvc",StudentService.class);
		
		System.out.println(svc1.getStudents().size());
		System.out.println(svc1.hashCode());
		
		StudentService svc2 = context.getBean("StudentSvc",StudentService.class); 
		System.out.println(svc2.hashCode());
	}
}
