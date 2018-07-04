package com.techlabs.contact.service.model;

import java.util.*;

import com.techlabs.contact.repository.UsersDB;

public class LoginService {
	private static LoginService service;
	private Map<String, String> users;
	private UsersDB userTool = new UsersDB();

	private LoginService() {
		
	}

	public static LoginService getInstance() {
		if (service == null) {
			service = new LoginService();
		}
		return service;
	}

	public void addUser(String name, String password) {
		userTool.addUser(name, password);
	}
	
	public boolean checkUser(String name, String password) {
		users = userTool.getUsers();
		for(Map.Entry<String, String> entry : users.entrySet()) {
			if(name.equals(entry.getKey()) && password.equals(entry.getValue())){
				return true;
			}
		}
		return false;
	}
}
