package com.techlabs.studentlist.test;

import java.util.*;

import com.techlabs.studentlist.*;

public class StudentListTest {
	
	static Scanner in = new Scanner(System.in);
	static SerializeDeserialize sd = new SerializeDeserialize();
	static ArrayList<Student> studentList = (ArrayList<Student>) sd
			.deserialize();

	public static void printDetails() {
		for (Student s : studentList) {
			System.out.println(s.getFirstName() + " " + s.getLastName() + " "
					+ s.getAge());
		}
	}

	public static void addStudent() {
		System.out.println("Enter First name: ");
		String fname = in.next();
		System.out.println("Enter Last name: ");
		String lname = in.next();
		System.out.println("Enter Age: ");
		int age = in.nextInt();
		studentList.add(new Student(fname, lname, age));
		sd.serialize(studentList);
	}

	public static void main(String[] args) {
		String ch;
		int selection;

		do {
			System.out.println("1.Add Student\n2.DIsplay Student");
			selection = in.nextInt();
			switch (selection) {
			case 1:
				addStudent();
				break;
			case 2:
				printDetails();
				break;
			}
			System.out.println("continue?");
			ch = in.next();
		} while (ch.equals("y"));
		in.close();
	}
}