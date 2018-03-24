package com.techlabbs.crudapp.db;

import com.techlabs.crudable.*;

public class CustomerDB implements ICrudable {
	
	public void create() {
		System.out.println("customer created");
	}

	public void read() {
		System.out.println("customer read");
	}

	public void update() {
		System.out.println("customer updated");
	}

	public void delete() {
		System.out.println("customoer deleted");
	}
}
