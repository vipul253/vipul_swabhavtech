package com.techlabs.view.model;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.model.Student;

public class DisplayView {
	
	private List<Student> students;
	
	public DisplayView() {
		students = new ArrayList<>();
		System.out.println("Display VM created");
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
