package com.sample.bank.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.sample.bank.entity.User;
import com.sample.bank.service.UserAccountService;
import com.sample.bank.view.model.RegisterView;

public class RegisterAction implements ModelDriven<RegisterView> {

	@Autowired
	private UserAccountService svc;
	private RegisterView registerView;

	@Override
	public RegisterView getModel() {
		registerView = new RegisterView();
		return registerView;
	}

	public String execute() {
		return "success";
	}
	
	public String register() {
		svc.addAccount(new User(registerView.getName(),registerView.getPassword()), registerView.getAmount());
		return "success";
	}

}
