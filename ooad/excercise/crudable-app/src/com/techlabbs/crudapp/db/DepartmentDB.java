package com.techlabbs.crudapp.db;

import com.techlabs.crudable.ICrudable;

public class DepartmentDB implements ICrudable {

	public void create() {
		System.out.println("Department created");
	}

	public void read() {
		System.out.println("Department read");
	}

	public void update() {
		System.out.println("Department updated");
	}

	public void delete() {
		System.out.println("Department deleted");
	}
}
