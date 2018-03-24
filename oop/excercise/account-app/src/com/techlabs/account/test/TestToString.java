package com.techlabs.account.test;

import com.techlabs.account.*;

public class TestToString {
	public static void main(String[] args) {
		Account acc1 = new Account(123,"nieu",500);
		System.out.println(acc1);
		System.out.println(acc1.toString());
	}
}
