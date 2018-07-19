package com.sample.bank.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sample.bank.service.UserAccountService;
import com.sample.bank.view.model.LoginView;

public class LoginAction extends ActionSupport implements
		ModelDriven<LoginView>, SessionAware {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserAccountService svc;
	private LoginView loginView;
	private Map<String, Object> userSession;

	@Override
	public LoginView getModel() {
		loginView = new LoginView();
		return loginView;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

	public String execute() {
		return "success";
	}

	public String checkUser() {
		if (svc.checkUser(loginView.getUsername(), loginView.getPassword())) {
			String role = svc.getRole(loginView.getUsername(), loginView.getPassword());
			if(role.equals("admin")){
				userSession.put("name", loginView.getUsername());
				userSession.put("role", "admin");
				return "admin";
			}
			if(role.equals("user")) {
				String accountStatus = svc.getAccountStatus(loginView.getUsername(), loginView.getPassword());
				if(accountStatus.equals("active")){
					userSession.put("name", loginView.getUsername());
					userSession.put("role", "user");
					svc.setLoginTime(loginView.getUsername());
					return "user";
				}
				addFieldError("loginError", "your account is locked");
				return "input";
			}
		}
		addFieldError("loginError", "invalid user name or password");
		return "input";

	}
	
	public String doLogout(){
		userSession.clear();
		return "success";
	}

}
