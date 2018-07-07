package com.techlabs.service;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

	private static StudentService service;
	private List<Student> students;

	private StudentService() {
		students = new ArrayList<Student>();
	}

	public static StudentService getInstance() {
		if (service == null) {
			service = new StudentService();
		}
		return service;
	}

	public List<Student> getStudents() {
		if (students.isEmpty()) {
			return null;
		}
		return students;
	}

	public void addStudent(Student student) {
		students.add(student);
	}
}