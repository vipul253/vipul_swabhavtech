package com.techlabs.shoppingcart;

import java.util.*;

public class Customer {
	
	private String name;
	private String password;
	private List<Order> orders;

	public Customer(String name) {
		this.orders = new ArrayList<Order>();
		this.name = name;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

	public String getName() {
		return this.name;
	}

	public String getOrder() {
		String str = "";
		for (Order o : orders) {
			str += o.toString();
		}
		return str;
	}
}