package com.sample.bank.view.model;

import java.util.List;

import com.sample.bank.entity.Transaction;

public class UserView {
	
	private List<Transaction> transactions;

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
