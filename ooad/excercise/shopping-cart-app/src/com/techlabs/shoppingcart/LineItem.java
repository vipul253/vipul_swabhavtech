package com.techlabs.shoppingcart;

public class LineItem {
	private Product product;
	private int quantity;

	public LineItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "\n" + this.product.toString() + " Quantity:" + this.quantity
				+ " Total Cost:" + this.CalculateTotalCost();
	}

	public double CalculateTotalCost() {
		return this.quantity * this.product.CalculateProductCost();
	}

	public Product getProduct() {
		return this.product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return this.quantity;
	}
}
