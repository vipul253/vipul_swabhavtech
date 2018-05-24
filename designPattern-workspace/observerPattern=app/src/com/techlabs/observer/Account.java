package com.techlabs.observer;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int number;
	private String name;
	private double balance;
	private List<AccountListener> listeners;
	
	public Account(int number,String name,double balance){
		this.number=number;
		this.name=name;
		this.balance=balance;
		listeners=new ArrayList<AccountListener>();
	}
	
	public void deposit(int amount){
		this.balance=this.balance+amount;
		notifyListeners();
	}
	
	public void withdraw(int amount){
		this.balance=this.balance-amount;
		notifyListeners();
	}
	
	public void addObserver(AccountListener listener){
		listeners.add(listener);
	}
	
	private void notifyListeners(){
		for(AccountListener l: listeners){
			l.balanceChanged(this);
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	
}
