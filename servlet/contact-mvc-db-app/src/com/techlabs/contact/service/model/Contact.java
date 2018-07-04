package com.techlabs.contact.service.model;

import java.util.UUID;

public class Contact {

	private String Id;
	private String name;
	private String email;
	private String number;

	public Contact(String name, String email, String number) {
		this.Id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.number = number;
	}
	
	public Contact(String uid,String name, String email, String number){
		this.Id = uid;
		this.name = name;
		this.email = email;
		this.number = number;
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getNumber() {
		return this.number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
