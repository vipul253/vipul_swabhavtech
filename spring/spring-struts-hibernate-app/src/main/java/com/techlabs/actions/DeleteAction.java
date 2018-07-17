package com.techlabs.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.StudentService;
import com.techlabs.view.model.DeleteView;

public class DeleteAction implements ModelDriven<DeleteView> {
	@Autowired
	private StudentService svc;
	private DeleteView delete;

	@Override
	public DeleteView getModel() {
		delete = new DeleteView();
		return delete;
	}

	public String execute() {
		return "success";
	}
	
	public String deleteStudent() {
		System.out.println(delete.getId());
		svc.deleteStudent(delete.getId());
		return "success";
	}
}
