package com.techlabbs.crudapp.db;

import com.techlabs.crudable.ICrudable;

public class InvoiceDB implements ICrudable {
	
	public void create() {
		System.out.println("invoice created");
	}

	public void read() {
		System.out.println("invoice read");
	}

	public void update() {
		System.out.println("invoice updated");
	}

	public void delete() {
		System.out.println("invoice deleted");
	}
}
