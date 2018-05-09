package com.techlabs.Account;

public class Account {
	private final int accno;
	private final String name;
	protected double balance;

	public Account(int accno, String name, double balance) {
		this.accno = accno;
		this.name = name;
		this.balance = balance;
	}

	public void withdraw(double amount) {
		if (amount > this.balance - 500) {
			throw new InsufficientFundsException(this);
		}
		this.balance -= amount;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public int getAccno() {
		return accno;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}
}
