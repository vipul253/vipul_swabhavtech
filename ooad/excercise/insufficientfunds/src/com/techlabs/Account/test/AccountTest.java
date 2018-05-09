package com.techlabs.Account.test;

import com.techlabs.Account.*;

public class AccountTest {

	public static void main(String[] args) {
		Account acc1 = new Account(12345223,"Vipul",500);
		try{
			acc1.withdraw(5000);
		}
		catch(InsufficientFundsException efs){
			System.out.println(efs.getMessage());
		}
		
		finally{
			printDetails(acc1);
		}
	}
	public static void printDetails(Account acc) {
		System.out.println("Accno:" + acc.getAccno() + " Name:" + acc.getName()
				+ " Balance:" + acc.getBalance());
	}

}
