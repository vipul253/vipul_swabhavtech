package com.techlabs.account.test;

import com.techlabs.account.*;

public class AccountTest {

	public static void printDetails(Account a) {
		System.out.println("Account no:" + a.getAccno() + " Name:"
				+ a.getName() + " Balance:" + a.getBalance());
	}

	public static void main(String[] args) {
		Account acc1 = new Account(12345, "Vipul", 1000);
		Account acc2 = new Account(23456, "Neiu");
		Account acc3 = new Account(23456, "Abc", 500);

		printDetails(acc1);
		printDetails(acc2);

		acc1.deposit(15000);
		acc2.withdraw(500);

		printDetails(acc1);
		printDetails(acc2);

		acc1.withdraw(15500);
		printDetails(acc1);

		acc2.deposit(100);
		printDetails(acc2);

		System.out.println((acc1.whoIsRich(acc3)).getName());
		System.out.println(Account.HeadCount());
	}

}
