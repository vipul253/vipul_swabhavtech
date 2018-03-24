package com.techlabs.account.inheritance;

public class CurrentAccount extends Account {
	public CurrentAccount(int accno, String name, double balance) {
		super(accno, name, balance);
	}

	@Override
	public void withdraw(double amount) {
		this.balance -= amount;
	}
}
