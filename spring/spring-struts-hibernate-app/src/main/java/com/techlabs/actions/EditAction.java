package com.techlabs.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.service.StudentService;
import com.techlabs.view.model.EditView;

public class EditAction implements ModelDriven<EditView> {

	@Autowired
	private StudentService svc;
	private EditView edit;
	private int id;

	@Override
	public EditView getModel() {
		edit = new EditView();
		id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		edit.setView(svc.getById(id));
		return edit;
	}

	public String execute() {
		return "success";
	}

	public String editStudent() {
		svc.editStudent(edit);
		return "success";
	}

}
