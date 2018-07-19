package com.sample.bank.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.sample.bank.service.UserAccountService;
import com.sample.bank.view.model.AdminView;

public class AdminDisplayAction implements ModelDriven<AdminView>, SessionAware{
	
	@Autowired
	private UserAccountService svc;
	private Map<String, Object> userSession;
	private AdminView adminView;
	
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	@Override
	public AdminView getModel() {
		adminView = new AdminView();
		return adminView;
	}
	
	public String execute() {
		adminView.setUsers(svc.getUsers());
		return "success";
	}
	
	
	
}
