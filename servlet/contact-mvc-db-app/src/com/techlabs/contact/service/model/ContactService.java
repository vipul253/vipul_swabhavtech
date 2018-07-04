package com.techlabs.contact.service.model;

import java.util.*;

import com.techlabs.contact.repository.ContactDB;

public class ContactService {

	private static ContactService service;
	private ContactDB contactDB;
	private List<Contact> contacts;

	private ContactService() {
		contactDB = new ContactDB();
	}

	public List<Contact> getContacts() {
		contacts = contactDB.getContacts();
		return contacts;
	}

	public static ContactService getInstance() {
		if (service == null) {
			service = new ContactService();
		}
		return service;
	}

	public void addContact(String name, String email, String number) {
		contactDB.addContact(new Contact(name, email, number));
	}

	public void editContact(String id, Contact newContact) {
		contactDB.editContact(id, newContact);
	}
}
