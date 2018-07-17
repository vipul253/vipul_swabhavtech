package com.techlabs.sample.bank.model;

import java.util.Date;
import java.util.UUID;

public class Transaction {
	private String Id;
	private String name;
	private double amount;
	private String type;
	private Date date;

	public Transaction() {

	}

	public Transaction(String name, double amount, String type) {
		this.Id = UUID.randomUUID().toString();
		this.name = name;
		this.amount = amount;
		this.type = type;
	}

	public Transaction(String name, double amount, String type, Date date) {
		this(name, amount, type);
		this.date = date;
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setType(String type) {
		this.type = type;
	}

}
