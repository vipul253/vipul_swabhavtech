package com.techlabs.student.test;

import java.util.*;
import com.techlabs.student.*;

public class StudentTest {

	public static void main(String[] args) {

		ArrayList<Student> studentList = new ArrayList<Student>();
		SerializeDeserialize sd = new SerializeDeserialize();
		Student s1 = new Student("Vipul", "Sawant", 21);
		Student s2 = new Student("abc", "defg", 22);
		studentList.add(s1);
		studentList.add(s2);
		for (Student s : studentList) {
			System.out.println(s.getFirstName() + " " + s.getLastName() + " "
					+ s.getAge());
		}
		sd.serialize(studentList);
		
		ArrayList<Student> studentList1 = (ArrayList<Student>) sd.deserialize();

		for (Student s : studentList1) {
			System.out.println(s.getFirstName() + " " + s.getLastName() + " "
					+ s.getAge());
		}
	}

}
