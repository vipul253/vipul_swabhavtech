package com.shopping.cart.model;

import java.util.UUID;

public class Product {
	private String ID = UUID.randomUUID().toString();
	private String name;
	private double cost;
	private double discount;

	public double CalculateProductCost() {
		return this.cost - (this.discount / 100) * cost;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}