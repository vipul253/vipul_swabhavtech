package com.techlabs.contactService.model;

import java.util.*;

public class LoginService {
	private static LoginService service;
	private Map<String, String> users;

	public LoginService() {
		users = new HashMap<String, String>();
		addUser("vipul", "123");
	}

	public static LoginService getInstance() {
		if (service == null) {
			service = new LoginService();
		}
		return service;
	}

	public void addUser(String name, String password) {
		users.put(name, password);
	}
	
	public boolean checkUser(String name, String password) {
		for(Map.Entry<String, String> entry : users.entrySet()) {
			if(name.equals(entry.getKey()) && password.equals(entry.getValue())){
				return true;
			}
		}
		return false;
	}
}
