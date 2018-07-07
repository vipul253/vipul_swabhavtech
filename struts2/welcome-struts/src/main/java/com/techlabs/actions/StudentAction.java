package com.techlabs.actions;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.techlabs.service.Student;
import com.techlabs.service.StudentService;

public class StudentAction implements Action {
	private StudentService service = StudentService.getInstance();
	private List<Student> students = service.getStudents();
	
	
	public List<Student> getStudents() {
		return students;
	}
	
	@Override
	public String execute() {
		return this.SUCCESS;
	}
	
	public String add(){
		return this.NONE;
	}
}
