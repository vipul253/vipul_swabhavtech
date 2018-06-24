package com.techlabs.contact;

import java.util.*;


public class ContactService {
	private List<Contact> contacts;
	
	public ContactService() {
		contacts = new ArrayList<Contact>();
		addContact("vipul", "abc@abc.com", "0123456789");
		addContact("pratik", "abc@abc.com", "0123456789");
		addContact("sarvesh", "abc@abc.com", "0123456789");
	}
	
	public List<Contact> getContacts(){
		if(!(contacts.isEmpty())){
			return contacts;
		}
		return null;
	}
	
	public void addContact(String name,String email,String number) {
		contacts.add(new Contact(name,email,number));
	}
}
