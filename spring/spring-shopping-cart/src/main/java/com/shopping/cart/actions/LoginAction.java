package com.shopping.cart.actions;

import java.util.HashSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.cart.entity.LineItem;
import com.shopping.cart.service.CustomerService;
import com.shopping.cart.view.model.LoginView;

public class LoginAction extends ActionSupport implements SessionAware,ModelDriven<LoginView> {

	private static final long serialVersionUID = 5L;
	
	@Autowired
	private CustomerService customerTool;
	private Map<String, Object> userSession;
	private LoginView loginView;
	
	@Override
	public LoginView getModel() {
		loginView = new LoginView();
		return loginView;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	public String execute(){
		return "login";
	}
	
	public String checkUser() {
		if(customerTool.checkUser(loginView.getUsername(),loginView.getPassword())){
			userSession.put("name", loginView.getUsername());
			userSession.put("lineItems", new HashSet<LineItem>());
			return "success";
		}
		addFieldError("loginError", "invalid user name or password");
		return "input";
	}
	
	public String doLogout(){
		userSession.clear();
		return "success";
	}
}
