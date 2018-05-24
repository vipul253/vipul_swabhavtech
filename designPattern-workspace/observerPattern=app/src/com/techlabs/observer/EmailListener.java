package com.techlabs.observer;

public class EmailListener implements AccountListener {
	
	@Override
	public void balanceChanged(Account account) {
		System.out.println("Email: "+account.getName()+" your balance is "+account.getBalance()+" for account number:"+account.getNumber());
	}
}
