package com.techlabs.shoppingcart.test;

import com.techlabs.shoppingcart.*;
import java.util.*;

public class ShoppingCartTest {

	public static void main(String[] args) {
		Customer customer1 = new Customer("Vipul");
		Order order = new Order(Calendar.getInstance().getTime());
		
		customer1.addOrder(order);
		order.addToCart(new LineItem(new Product(23, "iphone4",67990, 25),2));
		order.addToCart(new LineItem(new Product(21, "S9 EDGE",63390, 25),3));
		Order order2 = new Order(Calendar.getInstance().getTime());
		customer1.addOrder(order2);
		order2.addToCart(new LineItem(new Product(23, "MI MAX 4",679230, 25),2));
		order2.addToCart(new LineItem(new Product(21, "Galax note 8",623390, 25),3));
		order2.addToCart(new LineItem(new Product(21, "Galax note 8",623390, 25),4));
		
		
		CustomerHistory(customer1);
		

	}
	
	public static void CustomerHistory(Customer customer){
		System.out.println(customer);
	}

}
