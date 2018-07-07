package com.techlabs.contacts.actions;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.contacts.service.Contact;
import com.techlabs.contacts.service.ContactService;

public class EditContactAction implements ModelDriven<Contact>, SessionAware {

	private Map<String, Object> userSession;
	private ContactService contactTool = ContactService.getInstance();
	private Contact contact;
	private String id;

	public String execute() {
		if(userSession.isEmpty()){
			return "login";
		}
		return "success";
	}

	public String edit() {
		contactTool.editContact(id, contact);
		return "success";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Contact getModel() {
		id = ServletActionContext.getRequest().getParameter("id");
		contact = contactTool.getById(id);
		return contact;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
}
