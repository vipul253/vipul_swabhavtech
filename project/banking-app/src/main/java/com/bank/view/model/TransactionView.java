package com.bank.view.model;

import com.bank.enums.AccountType;
import com.bank.enums.TransactionType;

public class TransactionView {
	private AccountType accountType;
	private TransactionType transactionType;
	private double amount;

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
