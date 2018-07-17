package com.techlabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Student;
import com.techlabs.repository.StudentRepository;
import com.techlabs.view.model.AddView;
import com.techlabs.view.model.EditView;

@Service("StudentSvc")
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public StudentService() {
		System.out.println("service created");
	}

	public List<Student> getStudents() {
		return repo.get();
	}

	public void addStudent(AddView addView) {
		repo.add(addView);
	}

	public void editStudent(EditView editView) {
		repo.edit(editView);
	}

	public void deleteStudent(int id) {
		repo.delete(id);
	}
	
	public Student getById(int id) {
		return repo.getById(id);
	}

}
