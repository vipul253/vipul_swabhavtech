package com.shopping.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shopping.cart.model.*;

public class CustomerService {
	
	private static CustomerService customerTool;
	private List<Customer> customers;
	
	private CustomerService() {
		customers = new ArrayList<Customer>();
		Customer c1 = new Customer();
		c1.setName("vipul");
		c1.setPassword("123");
		customers.add(c1);
		
		Customer c2 = new Customer();
		c2.setName("neiu");
		c2.setPassword("123");
		customers.add(c2);
	}
	
	public static CustomerService getInstance(){
		if (customerTool == null) {
			customerTool = new CustomerService();
		}
		return customerTool;
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	
	public boolean checkUser(String name, String password) {
		for(Customer c : customers) {
			if(name.equals(c.getName()) && password.equals(c.getPassword())){
				return true;
			}
		}
		return false;
	}
}
