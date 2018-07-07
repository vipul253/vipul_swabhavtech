package com.techlabs.contacts.service;

import java.util.UUID;

public class Contact {

	private String Id = UUID.randomUUID().toString();
	private String name;
	private String email;
	private String number;

	public String getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
