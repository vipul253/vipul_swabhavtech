package com.techlabs.observer.test;

import com.techlabs.observer.*;

public class AccountObserverTest {

	public static void main(String[] args) {
		Account acc1 = new Account(123, "nieu", 2345);
		AccountListener smsAlert = new SmsListener();
		AccountListener emailAlert = new EmailListener();
		
		acc1.addObserver(smsAlert);
		acc1.addObserver(emailAlert);
		acc1.deposit(156);
		acc1.withdraw(468);

	}

}
