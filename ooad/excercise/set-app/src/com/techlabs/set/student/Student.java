package com.techlabs.set.student;

public class Student implements Comparable<Student> {
	private int rollno;
	private String name;

	public Student(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	@Override
	public int compareTo(Student s) {
		return this.name.compareTo(s.name);
	}

	@Override
	public boolean equals(Object std) {
		Student student = (Student) std;
		return student.name.equalsIgnoreCase(this.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	public int getRollNo() {
		return this.rollno;
	}

	public String getName() {
		return this.name;
	}

}
