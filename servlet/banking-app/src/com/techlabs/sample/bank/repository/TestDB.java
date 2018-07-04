package com.techlabs.sample.bank.repository;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.sample.bank.model.Transaction;

public class TestDB {

	public static void main(String[] args) {
		List<Transaction> l = new ArrayList<Transaction>();
		UserDB ud = new UserDB();
		BankDB bd = new BankDB();
		
		System.out.println(ud.checkUser("vipul", "12345"));
		//ud.addUser("vipul", "123", 3000);
		
		//bd.makeTransaction(new Transaction("vipul", 1000, "D"));
		l=bd.getTransactions("vipul");
		System.out.println(l.get(0).getName());
	}
}