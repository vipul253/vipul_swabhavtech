package com.bank.view.model;

import java.util.List;

import com.bank.entity.Account;
import com.bank.entity.Transaction;

public class UserView {
	
	private Account savingsAccount;
	private Account currentAccount;
	private List<Transaction> transactions;
	private double amount;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Account getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(Account savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	public Account getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}	
	
}
