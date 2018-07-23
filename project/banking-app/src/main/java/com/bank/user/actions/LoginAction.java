package com.bank.user.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.bank.enums.UserRole;
import com.bank.service.UserAccountService;
import com.bank.view.model.LoginView;

public class LoginAction extends ActionSupport implements ModelDriven<LoginView>, SessionAware {

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
			if(verifyUser()) {
				addFieldError("loginError", "verify account from email first.");
				return "input";
			}
			checkAttempts();
			UserRole role = svc.getRole(loginView.getUsername(), loginView.getPassword());
			return checkRole(role);
		}
		svc.increaseAttempts(loginView.getUsername());
		addFieldError("loginError", "invalid user name or password");
		return "input";
	}

	public String doLogout() {
		userSession.clear();
		return "success";
	}

	public String checkRole(UserRole role) {
		if (role.equals(UserRole.ADMIN)) {
			userSession.put("name", loginView.getUsername());
			userSession.put("role", UserRole.ADMIN);
			svc.setLoginTime(loginView.getUsername());
			svc.resetAttempts(loginView.getUsername());
			return "admin";
		}
		if (role.equals(UserRole.USER)) {
			boolean isActive = svc.getAccountState(loginView.getUsername(), loginView.getPassword());
			return checkAccountState(isActive);
		}
		return "input";
	}

	public String checkAccountState(boolean isActive) {
		if (isActive) {
			userSession.put("name", loginView.getUsername());
			userSession.put("role", UserRole.USER);
			svc.setLoginTime(loginView.getUsername());
			svc.resetAttempts(loginView.getUsername());
			return "user";
		}
		addFieldError("loginError", "your account is locked");
		return "input";
	}

	public void checkAttempts() {
		if (svc.getAttempts(loginView.getUsername()) >= 3) {
			svc.changeAccountState(loginView.getUsername());
		}
	}
	
	public boolean verifyUser() {
		if(!svc.checkValid(loginView.getUsername())) {
			return true;
		}
		return false;
	}
}
