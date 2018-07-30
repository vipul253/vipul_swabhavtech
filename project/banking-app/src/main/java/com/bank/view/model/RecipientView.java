package com.bank.view.model;

import java.util.ArrayList;
import java.util.List;

import com.bank.entity.Recipient;

public class RecipientView {
	
	List<Recipient> recipients = new ArrayList<>();

	public List<Recipient> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<Recipient> recipients) {
		this.recipients = recipients;
	}
	
}
