package com.techlabs.logger;

import com.techlabs.account.IAccount;

public class Logger extends LogDecorator {

	public Logger(IAccount account) {
		super(account);
	}

	@Override
	public void deposit(double amount) {
		System.out.println("before");
		acc.deposit(amount);
		System.out.println("After");
	}
}
