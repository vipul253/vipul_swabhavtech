package com.techlabs.shoppingcart;

import java.util.*;
public class Customer {
	private String name;
	private List<Order> order;
	
	public Customer(String name){
		this.order=new ArrayList<Order>();
		this.name=name;
	}
	@Override
	public String toString(){
		return "Customer name:"+this.name+this.getOrder();
	}
	public void addOrder(Order order){
		this.order.add(order);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getOrder(){
		String str="";
		for(Order o: order){
			str+= o.toString();
		}
		return str;
	}
	
	
}
