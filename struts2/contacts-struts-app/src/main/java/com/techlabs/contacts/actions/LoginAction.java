package com.techlabs.contacts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.techlabs.contacts.service.LoginService;

public class LoginAction implements SessionAware {
	
	private Map<String, Object> userSession;
	private LoginService loginTool = LoginService.getInstance();
	private String username;
	private String pwd;
	private String disp="none";
	private String error;
	
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	public String execute(){
		return "success";
	}
	
	public String checkUser() {
		if(loginTool.checkUser(username, pwd)){
			userSession.put("name", username);
			return "success";
		}
		disp="block";
		error="invalid username or password";
		return "login";
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

	public String getDisp() {
		return disp;
	}

	public String getError() {
		return error;
	}

	public void setDisp(String disp) {
		this.disp = disp;
	}

	public void setError(String error) {
		this.error = error;
	}
}
