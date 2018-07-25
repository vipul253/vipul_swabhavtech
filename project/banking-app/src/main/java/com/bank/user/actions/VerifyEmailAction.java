package com.bank.user.actions;

import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.bank.service.UserAccountService;

public class VerifyEmailAction {
	
	@Autowired
	private UserAccountService svc;
	
	public String verifyUser() {
		System.out.println("hello");
		UUID id = UUID.fromString(ServletActionContext.getRequest().getParameter("id"));
		svc.verify(id);
		System.out.println("hello");
		return "success";
	}
}
