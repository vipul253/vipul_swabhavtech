package com.techlabs.shoppingcart;

import java.util.*;

public class Order {
	private Date date;
	private List<LineItem> orders;

	public Order(Date date) {
		this.date = date;
		orders = new ArrayList<LineItem>();
	}

	@Override
	public String toString(){
		return "\n"+this.date.toString()+this.getLineItem()+" Final Cost:"+this.checkoutCost();

	}

	public void addToCart(LineItem li) {
		for(LineItem l: orders){
			if(li.getProduct().getID()==l.getProduct().getID()){
				l.setQuantity(li.getQuantity()+l.getQuantity());
				return;
			}
		}
		orders.add(li);
	}

	public double checkoutCost() {
		double finalCost = 0;
		for (LineItem li : orders) {
			finalCost += li.CalculateTotalCost();
		}
		return finalCost;
	}

	public Date getDate() {
		return this.date;
	}
	
	public String getLineItem(){
		String str="";
		for(LineItem li : orders){
			str+=li.toString();
		}
		return str;
	}
}
