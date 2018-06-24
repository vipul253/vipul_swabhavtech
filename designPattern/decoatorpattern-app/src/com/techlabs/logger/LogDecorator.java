package com.techlabs.logger;

import com.techlabs.account.IAccount;

public abstract class LogDecorator implements IAccount {
	protected IAccount acc;
	
	public LogDecorator(IAccount account){
		this.acc=account;
	}

	public void deposit(double amount) {
		acc.deposit(amount);

	}

	public void withdraw(double amount) {
		acc.withdraw(amount);

	}
}
