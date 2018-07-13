package com.shopping.cart.actions;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.shopping.cart.service.CustomerService;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5L;
	private Map<String, Object> userSession;
	private CustomerService customerTool = CustomerService.getInstance();
	private String username;
	private String pwd;
	
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	public Map<String,Object> getSession(){
		return userSession;
	}
	
	public String execute(){
		return "login";
	}
	
	public String checkUser() {
		if(customerTool.checkUser(username, pwd)){
			userSession.put("name", username);
			return "success";
		}
		addFieldError("loginError", "invalid user name or password");
		return "input";
	}
	
	public String doLogout(){
		userSession.clear();
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
