package com.shopping.cart.model;

import java.util.*;

public class Order {
	
	private String ID = UUID.randomUUID().toString();
	private Date date;
	private List<LineItem> lineItems;

	public Order(Date date) {
		this.date = date;
		lineItems = new ArrayList<LineItem>();
	}

	public String getID() {
		return ID;
	}

	public void addToCart(LineItem li) {
		for (LineItem item : lineItems) {
			if (li.getProduct().getID() == item.getProduct().getID()) {
				item.setQuantity(li.getQuantity() + item.getQuantity());
				return;
			}
		}
		lineItems.add(li);
	}

	public void removeFromCart(String id) {
		Iterator<LineItem> iterator = lineItems.iterator();
		while (iterator.hasNext()) {
			LineItem item = iterator.next();
			if (item.getProduct().getID().equals(id)) {
				iterator.remove();
			}
		}
	}

	public double checkoutCost() {
		double finalCost = 0;
		for (LineItem li : lineItems) {
			finalCost += li.CalculateTotalCost();
		}
		return finalCost;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public Date getDate() {
		return this.date;
	}
}
