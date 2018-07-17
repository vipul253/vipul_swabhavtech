package com.techlabs.repository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.techlabs.model.Student;

@Repository
public class StudentRepository {

	public List<Student> get() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(113, "vipul", "sawant", "mumbai"));
		students.add(new Student(113, "pratik", "chaurasia", "mumbai"));
		students.add(new Student(113, "sarvesh", "nerurkar", "mumbai"));
		return students;
	}
}
