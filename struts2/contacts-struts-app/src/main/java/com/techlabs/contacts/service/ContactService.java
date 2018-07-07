package com.techlabs.contacts.service;

import java.util.*;

public class ContactService {
	
	private static ContactService service;
	private List<Contact> contacts;
	private Contact c = new Contact();

	private ContactService() {
		contacts = new ArrayList<Contact>();
		c.setName("vipul");
		c.setEmail("abc@abc");
		c.setNumber("123456789");
		contacts.add(c);
		
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
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public void editContact(String id, Contact newContact){
		for(Contact contact : contacts){
			if(id.equals(contact.getId())){
				int i = contacts.indexOf(contact);
				contacts.set(i, newContact);
			}
		}
	}
	
	public Contact getById(String id){
		for(Contact contact : contacts){
			if(id.equals(contact.getId())){
				return contact;
			}
		}
		return null;
	}
}
