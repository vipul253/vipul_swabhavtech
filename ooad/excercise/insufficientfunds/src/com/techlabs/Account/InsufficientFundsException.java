package com.techlabs.Account;

public class InsufficientFundsException extends RuntimeException {
	private Account account;
	private static final long serialVersionUID = 12L;
	
	public InsufficientFundsException(Account account){
		//super("Your balance isn't sufficient for this transaction "+acc.getName()+".");
		this.account=account;
	}
	
	@Override
	public String getMessage(){
		return "Your balance isn't sufficient for this transaction "+account.getName()+".";
	}
}