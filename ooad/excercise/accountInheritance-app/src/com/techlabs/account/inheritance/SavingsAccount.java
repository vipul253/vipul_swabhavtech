package com.techlabs.account.inheritance;

public class SavingsAccount extends Account {

	public SavingsAccount(int accno, String name, double balance) {
		super(accno, name, balance);
	}

	@Override
	public void withdraw(double amount) {
		if (this.balance - amount >= 500)
			this.balance -= amount;
	}
}
