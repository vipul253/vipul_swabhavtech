package com.techlabs.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.service.Student;
import com.techlabs.service.StudentService;

public class AddStudentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private StudentService service = StudentService.getInstance();
	private Student student;
	
	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}
	
	public String executeAdd(){
		service.addStudent(student);
		return this.SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public void validate(){
	    if (student.getRollNo()>9999) {
	        addFieldError("student.rollNo", "roll no. should be within 9999");
	    }
	    if (student.getRollNo()==0) {
	        addFieldError("student.rollNo", "rollno can't be empty");
	    }
	    if(student.getName().isEmpty()){
	    	addFieldError("student.name", "name is required");
	    }
	    if(student.getEmail().isEmpty()){
	    	addFieldError("student.email", "email is required");
	    }
	    if(student.getMobileNo().isEmpty()){
	    	addFieldError("student.mobileNo", "mobile no. is required");
	    }
	    if(student.getMobileNo().length()>10){
	    	addFieldError("student.mobileNo","invalid number");
	    }
	}
}
