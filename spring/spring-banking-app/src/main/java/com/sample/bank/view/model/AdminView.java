package com.sample.bank.view.model;

import java.util.List;

import com.sample.bank.entity.Transaction;
import com.sample.bank.entity.User;

public class AdminView {
	
	private List<User> users;
	private List<Transaction> transactions;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
