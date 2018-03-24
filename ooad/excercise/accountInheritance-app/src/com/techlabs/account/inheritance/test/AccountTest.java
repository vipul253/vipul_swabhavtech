package com.techlabs.account.inheritance.test;

import com.techlabs.account.inheritance.*;

public class AccountTest {

	public static void main(String[] args) {
		SavingsAccount saving_acc = new SavingsAccount(321, "neiu", 1234);
		CurrentAccount current_acc = new CurrentAccount(123, "vipul", 5344);

		saving_acc.withdraw(1234);
		current_acc.withdraw(3534);
		printDetails(saving_acc);
		printDetails(current_acc);

	}

	public static void printDetails(Account acc) {
		System.out.println("Accno:" + acc.getAccno() + " Name:" + acc.getName()
				+ " Balance:" + acc.getBalance());
	}
}
