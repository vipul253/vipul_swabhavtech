package com.techlabs.contacts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.contacts.service.Contact;
import com.techlabs.contacts.service.ContactService;

public class AddContactAction implements ModelDriven<Contact>, SessionAware {
	
	private Map<String, Object> userSession;
	private ContactService contactTool = ContactService.getInstance();
	private Contact contact = new Contact();

	public String execute() {
		if(userSession.isEmpty()){
			return "login";
		}
		return "success";
	}
	
	public String add(){
		contactTool.addContact(contact);
		return "success";
	}

	@Override
	public Contact getModel() {
		// TODO Auto-generated method stub
		return contact;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
}
