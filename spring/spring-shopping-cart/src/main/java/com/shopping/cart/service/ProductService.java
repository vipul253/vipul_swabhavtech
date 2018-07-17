package com.shopping.cart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.entity.Product;
import com.shopping.cart.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public ProductService() {
		System.out.println("service created");
	}
	
	public List<Product> getProducts() {
		return repo.get();
	}
	
	public Product getById(UUID id){
		return repo.getById(id);
	}
}
