package com.techlabs.customer;

public class Customer {
	private int ID;
	private String firstName;
	private String lastName;
	private double spentAmt;
	private static int count;
	
	public Customer(String firstName,String lastName,double spentAmt){
		this.firstName=firstName;
		this.lastName=lastName;
		this.spentAmt=spentAmt;
		count++;
		this.ID=generateID();
	}
	
	private int generateID(){
		return 1100+count;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getName(){
		return this.firstName+""+this.lastName;
	}
	
	public double getSpentAmt(){
		return this.spentAmt;
	}
	
}
