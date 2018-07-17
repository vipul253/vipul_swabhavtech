package com.shopping.cart.view.model;

import java.util.ArrayList;
import java.util.List;

import com.shopping.cart.entity.Product;

public class DisplayView {

	private List<Product> products;
	private String selected;
	private int quantity;
	private double totalCost;
	private String id;

	public DisplayView() {
		products = new ArrayList<>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
