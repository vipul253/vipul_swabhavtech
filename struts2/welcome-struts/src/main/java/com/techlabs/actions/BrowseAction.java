package com.techlabs.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.Action;

public class BrowseAction implements Action {
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
    Date day = new Date();
    
	private String date = formatter.format(day);
	
	private String methodType = "GET";
	private String postback = "false";

	public String execute() throws Exception {
		return this.SUCCESS;
	}

	public String getDate() {
		return date;
	}
	
	public String getMethodType(){
		if(postback.equals("true")){
			methodType = "POST";
		}
		return methodType;
	}

	public String getPostback() {
		return postback;
	}

	public void setPostback(String postback) {
		this.postback = postback;
	}	

}
