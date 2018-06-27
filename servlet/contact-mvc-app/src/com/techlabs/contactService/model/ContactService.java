package com.techlabs.contactService.model;

import java.util.*;


public class ContactService {
	
	private static ContactService service;
	private List<Contact> contacts;
	
	
	private ContactService() {
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
	
	public static ContactService getInstance() {
		if(service == null){
            service = new ContactService();
        }
        return service;
	}
	
	public void addContact(String name,String email,String number) {
		contacts.add(new Contact(name,email,number));
	}
	
	public void editContact(String id, Contact newContact){
		for(Contact contact : contacts){
			if(id.equals(contact.getId())){
				int i = contacts.indexOf(contact);
				contacts.set(i, newContact);
			}
		}
	}
}
