package com.techlabs.observer;

public class SmsListener implements AccountListener {

	@Override
	public void balanceChanged(Account account) {
		System.out.println("SMS: " + account.getName() + " your balance is "
				+ account.getBalance() + " for account number:"
				+ account.getNumber());
	}

}
