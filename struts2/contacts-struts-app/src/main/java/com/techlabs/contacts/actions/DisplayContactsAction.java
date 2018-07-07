package com.techlabs.contacts.actions;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.techlabs.contacts.service.Contact;
import com.techlabs.contacts.service.ContactService;

public class DisplayContactsAction implements Action {
	
	private ContactService service = ContactService.getInstance();
	private List<Contact> contacts = service.getContacts();
	
	@Override
	public String execute() throws Exception {
		return "success";
	}

	public List<Contact> getContacts() {
		return contacts;
	}
}
