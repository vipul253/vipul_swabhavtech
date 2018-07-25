package com.bank.user.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.bank.enums.AccountType;
import com.bank.service.UserAccountService;
import com.bank.view.model.UserView;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<UserView>, SessionAware {

	@Autowired
	private UserAccountService svc;
	private Map<String, Object> userSession;
	private UserView userView;

	@Override
	public UserView getModel() {
		userView = new UserView();
		return userView;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

	public String execute() {
		userView.setTransactions(svc.getAllTransactions(userSession.get("name").toString()));
		return "success";
	}
	
	public String showAccounts() {
		userView.setCurrentAccount(svc.getCurrentAccount(userSession.get("name").toString()));
		userView.setSavingsAccount(svc.getSavingsAccount(userSession.get("name").toString()));
		return "success";
	}
	
	public String showTransactions() {
		userView.setTransactions(svc.getAllTransactions(userSession.get("name").toString()));
		return "success";
	}
	
	public String showRecipients() {
		return "success";
	}
	
	public String showAppointments() {
		return "success";
	}
	
	public String showProfile() {
		return "success";
	}

	public String showCurrentTransactions() {
		userView.setTransactions(svc.getTransactions(userSession.get("name").toString(), 
				AccountType.CURRENT));
		return "success";
	}
	
	public String showSavingsTransactions() {
		userView.setTransactions(svc.getTransactions(userSession.get("name").toString(), 
				AccountType.SAVINGS));
		return "success";
	}
	
	public String makeCurrentAccount() {
		svc.makeCurrentAccount(userSession.get("name").toString(),userView.getAmount());
		return "success";
	}
	
	public String makeSavingsAccount() {
		svc.makeSavingsAccount(userSession.get("name").toString(),userView.getAmount());
		return "success";
	}
}
