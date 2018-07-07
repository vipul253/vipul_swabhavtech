package com.shopping.cart.actions;

import java.util.List;

import com.shopping.cart.model.Product;
import com.shopping.cart.service.ProductService;

public class DisplayAction {

	private ProductService productTool = ProductService.getInstance();
	private List<Product> products = productTool.getProducts();
	private double selected;
	private int quantity;

	public String execute() {
		return "success";
	}

	public String addLineItem() {
		System.out.println(selected * quantity);
		return "success";
	}

	public List<Product> getProducts() {
		return products;
	}

	public double getSelected() {
		return selected;
	}

	public void setSelected(double selected) {
		this.selected = selected;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}