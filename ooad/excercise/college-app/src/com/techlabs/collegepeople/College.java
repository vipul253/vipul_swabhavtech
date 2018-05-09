package com.techlabs.collegepeople;

import java.util.*;

public class College {
	
	private List<Student> students;
	private List<Professor> professors;
	
	public College() {
		students = new ArrayList<Student>();
		professors = new ArrayList<Professor>();
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public void addProfessor(Professor p) {
		professors.add(p);
	}

	public Iterable<Student> getStudents() {
		return this.students;
	}

	public Iterable<Professor> getProfessors() {
		return professors;
	}

}
