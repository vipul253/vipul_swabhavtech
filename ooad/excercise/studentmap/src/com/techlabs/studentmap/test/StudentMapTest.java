package com.techlabs.studentmap.test;

import java.util.*;
import com.techlabs.studentmap.*;

public class StudentMapTest {

	public static void main(String[] args) {
		Student s1 = new Student(101,10,"A");
		Student s2 = new Student(101,10,"A");
		Student s3 = new Student(102,10,"B");
		
		Map<Student,Student> students = new LinkedHashMap<Student, Student>();
		
		students.put(s1, s1);
		students.put(s2, s2);
		students.put(s3, s3);
		System.out.println(students.size());
		
		for(Map.Entry<Student, Student> entry : students.entrySet()){
			Student key = entry.getKey();
			Student value = entry.getValue();
			System.out.println(key.getRollno()+ " "+ key.getStandard()+" "+value.getName());
		}

	}

}
