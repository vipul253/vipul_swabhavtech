package com.bank.user.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.bank.service.UserAccountService;
import com.bank.view.model.RecipientView;
import com.opensymphony.xwork2.ModelDriven;

public class RecipientAction implements ModelDriven<RecipientView>, SessionAware {

	@Autowired
	private UserAccountService svc;
	private Map<String, Object> userSession;
	private RecipientView recipientView;
	
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

	@Override
	public RecipientView getModel() {
		recipientView = new RecipientView();
		return recipientView;
	}
	
	public String execute() {
		recipientView.setRecipients(svc.getRecipients(userSession.get("name").toString()));
		return "success";
	}
	
}
