package com.techlabs.customer.test;

import com.techlabs.customer.*;

public class CustomerTest {
	
	public static void printDetails(Customer c) {
		System.out.println("ID:"+c.getID()+" Name:"+c.getName()+" Spending Amount:"+c.getSpentAmt());
	}
	
	public static void main(String[] args) {
		Customer c1= new Customer("Vipul ","Sawant",1000);
		Customer c2= new Customer("abc ","xyz",11000);
		
		printDetails(c1);
		printDetails(c2);
		
	}

}
