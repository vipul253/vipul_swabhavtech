package com.techlabs.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.StudentService;
import com.techlabs.view.model.DisplayView;

public class DisplayAction implements ModelDriven<DisplayView> {
	
	@Autowired
	private StudentService svc;
	private DisplayView display;
	
	@Override
	public DisplayView getModel() {
		display = new DisplayView();
		return display;
	}
	
	public String execute() {
		display.setStudents(svc.getStudents());
		System.out.println("executed");
		return "success";
	}

}
