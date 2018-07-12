package com.shopping.cart.model;

import java.util.*;

public class Customer {
	
	private String ID = UUID.randomUUID().toString();
	private String name;
	private String password;
	private List<Order> orders;

	public Customer() {
		this.orders = new ArrayList<Order>();
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}