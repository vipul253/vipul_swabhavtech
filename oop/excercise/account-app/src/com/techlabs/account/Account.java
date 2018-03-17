package com.techlabs.account;

public class Account {
	private int accno;
	private String name;
	private double balance;
	private static int count;

	public Account(int accno, String name, double balance) {
		this.accno = accno;
		this.name = name;
		this.balance = (balance >= 500) ? balance : 500;
		count++;

	}

	@Override
	public String toString() {
		return "[Acc no:" + this.accno + " Name:" + this.name + " Balance:"
				+ this.balance + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj){
			return true;
		}
		Account a = (Account) obj;
		return (this.accno == a.accno)
				&& (this.name.equals(a.name) && (this.balance == a.balance));
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	public Account(int accno, String name) {
		this(accno, name, 500);
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccno() {
		return this.accno;
	}

	public String getName() {
		return this.name;
	}

	public double getBalance() {
		return this.balance;
	}

	public void deposit(double ammount) {
		this.balance += ammount;
	}

	public void withdraw(double amount) {
		if (this.balance - amount >= 500)
			this.balance -= amount;
		else
			System.out.println("invalid amount withdrawn from "
					+ this.getAccno());
	}

	public Account whoIsRich(Account a) {
		if (this.balance == a.balance)
			return this;
		return this.balance > a.balance ? this : a;
	}

	public static int HeadCount() {
		return count;
	}
}
