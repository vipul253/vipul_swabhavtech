package com.shopping.cart.service;

import java.util.Calendar;

import com.shopping.cart.model.*;

public class OrderService {
	
	private static OrderService orderTool;
	private LineItem lineItem;
	private Order order;
	
	private OrderService(){
		order = new Order(Calendar.getInstance().getTime());
	}
	
	public static OrderService getInstance() {
		if (orderTool == null) {
			orderTool = new OrderService();
		}
		return orderTool;
	}
	
	public void addLineItem(Product product,int quantity){
		lineItem = new LineItem(product,quantity);
		order.addToCart(lineItem);
	}
	
	public void removeLineItem(String id){
		order.removeFromCart(id);
	}

	public Order getOrder() {
		return order;
	}
}
