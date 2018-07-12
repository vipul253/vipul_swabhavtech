package com.shopping.cart.model;

import java.util.UUID;

public class LineItem {
	
	private String ID = UUID.randomUUID().toString();
	private Product product;
	private int quantity;

	public LineItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public String getID() {
		return ID;
	}

	public double CalculateTotalCost() {
		return this.quantity * this.product.CalculateProductCost();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
