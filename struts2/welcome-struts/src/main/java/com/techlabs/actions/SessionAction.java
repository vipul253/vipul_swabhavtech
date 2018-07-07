package com.techlabs.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class SessionAction implements SessionAware {
	
	private Map<String, Object> countSession ;
	
	@Override
	public void setSession(Map<String, Object> session) {
		countSession = session;
	}
	
	public String execute(){
		increaseCount();
		return "success";
	}
	
	public void increaseCount(){
		Integer count=(Integer)countSession.get("newCount");
		countSession.put("oldCount", 0);
		if(count==null){
			count=0;
		} else {
			countSession.put("oldCount", count);
			count++;
		}
		countSession.put("newCount", count);
	}
}
