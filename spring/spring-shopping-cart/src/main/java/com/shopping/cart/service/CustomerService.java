package com.shopping.cart.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.entity.LineItem;
import com.shopping.cart.entity.Order;
import com.shopping.cart.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	private CustomerService() {
		System.out.println("service created");
	}
	
	public boolean checkUser(String name, String password) {
		if(repo.checkUser(name, password)){
			return true;
		}
		return false;
	}
	
	public void checkout(String name,Order order) {
		repo.addOrder(name,order);
	}
}
