package com.techlabs.setTest;

import java.util.HashSet;
import java.util.TreeSet;

import com.techlabs.set.student.*;

public class SetTest {

	public static void main(String[] args) {
		Student s1 = new Student(101,"A");
		Student s2 = new Student(101,"A");
		Student s3 = new Student(102,"C");
		
		HashSet<Student> list1 = new HashSet<Student>();
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);
		for(Student s : list1){
			System.out.println(s.getName());
		}
		
		TreeSet<Student> list2 = new TreeSet<Student>();
		list2.add(s1);
		list2.add(s2);
		list2.add(s3);
		for(Student s : list2){
			System.out.println(s.getName());
		}
	}

}
