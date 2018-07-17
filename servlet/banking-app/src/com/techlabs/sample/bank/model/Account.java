package com.techlabs.sample.bank.model;

import java.util.UUID;

public class Account {
	private String Id;
	private String name;
	private String password;
	private double balance;

	public Account(String name, String password, double balance) {
		this.Id = UUID.randomUUID().toString();
		this.name = name;
		this.password = password;
		this.balance = balance;
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public double getBalance() {
		return balance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
