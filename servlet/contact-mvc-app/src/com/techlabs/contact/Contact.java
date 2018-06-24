package com.techlabs.contact;

public class Contact {
	
	private String name;
	private String email;
	private String number;
	
	public Contact(String name, String email, String number) {
		this.name = name;
		this.email = email;
		this.number = number;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

