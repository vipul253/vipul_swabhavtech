package com.techlabs.account.inheritance;

public abstract class Account {
	private final int accno;
	private final String name;
	protected double balance;

	public Account(int accno, String name, double balance) {
		this.accno = accno;
		this.name = name;
		this.balance = balance;
	}

	public Account(int accno, String name) {
		this(accno, name, 500);
	}

	public abstract void withdraw(double amount);

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
