package com.techlabs.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.StudentService;
import com.techlabs.view.model.AddView;

public class AddAction implements ModelDriven<AddView> {
	
	@Autowired
	private StudentService svc;
	private AddView add;
	
	@Override
	public AddView getModel() {
		add = new AddView();
		return add;
	}
	
	public String execute() {
		return "success";
	}
	
	public String addStudent(){
		svc.addStudent(add);
		return "success";
	}
	
}
