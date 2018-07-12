package com.shopping.cart.view.model;

import java.util.List;

import com.shopping.cart.model.LineItem;
import com.shopping.cart.model.Order;
import com.shopping.cart.model.Product;
import com.shopping.cart.service.OrderService;
import com.shopping.cart.service.ProductService;

public class ShoppingCartView {

	private ProductService productTool = ProductService.getInstance();
	private OrderService orderTool = OrderService.getInstance();
	private List<Product> products = productTool.getProducts();
	private Order order = orderTool.getOrder();
	private List<LineItem> lineItems = order.getLineItems();
	private String selected;
	private String id;
	private int quantity;
	private double totalCost;

	public double getTotalCost() {
		if (productTool.getById(selected) != null) {
			totalCost = productTool.getById(selected).CalculateProductCost()
					* quantity;
		}
		return totalCost;
	}

	public void addLineItem() {
		orderTool.addLineItem(productTool.getById(selected), quantity);
	}

	public void removeLineItem() {
		orderTool.removeLineItem(id);
	}

	public Order getOrder() {
		return order;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public List<Product> getProducts() {
		return products;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
