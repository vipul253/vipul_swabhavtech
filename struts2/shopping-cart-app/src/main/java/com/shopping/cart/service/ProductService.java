package com.shopping.cart.service;

import java.util.ArrayList;
import java.util.List;

import com.shopping.cart.model.Product;

public class ProductService {

	private static ProductService productTool;
	private List<Product> products;

	private ProductService() {

		Product p1 = new Product();
		p1.setName("iPhone");
		p1.setCost(66000.0);
		p1.setDiscount(10.0);

		Product p2 = new Product();
		p2.setName("GalaxyS9");
		p2.setCost(55000.0);
		p2.setDiscount(10.0);

		Product p3 = new Product();
		p3.setName("Google Pixel");
		p3.setCost(60000.0);
		p3.setDiscount(10.0);

		products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
	}

	public static ProductService getInstance() {
		if (productTool == null) {
			productTool = new ProductService();
		}
		return productTool;
	}

	public List<Product> getProducts() {
		return products;
	}
}
