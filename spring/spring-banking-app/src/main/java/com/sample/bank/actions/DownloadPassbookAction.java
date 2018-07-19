package com.sample.bank.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.sample.bank.service.UserAccountService;
import com.sample.bank.view.model.UserView;

public class DownloadPassbookAction implements ModelDriven<UserView>,
		SessionAware {

	@Autowired
	private UserAccountService svc;
	private Map<String, Object> userSession;
	private UserView userView;

	@Override
	public UserView getModel() {
		userView = new UserView();
		return null;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	public String execute(){
		svc.makeCSV(userSession.get("name").toString());
		return "success";
	}

}
