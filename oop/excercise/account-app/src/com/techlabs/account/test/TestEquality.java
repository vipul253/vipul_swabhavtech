package com.techlabs.account.test;

import com.techlabs.account.*;

public class TestEquality {

	public static void main(String[] args) {
		
		Account acc1 = new Account(123,"nieu",500);
		Account acc2 = new Account(123,"nieu",500);
		
		System.out.println(acc1==acc2);
		System.out.println(acc1.equals(acc2));
		System.out.println(acc1.hashCode());
		System.out.println(acc2.hashCode());
		

	}

}
