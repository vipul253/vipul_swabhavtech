package com.techlabs.account.inheritance;

public class InsufficientFundsException extends RuntimeException {
	private static final long serialVersionUID = 12L;
	public InsufficientFundsException(String message){
		super(message);
	}
}
