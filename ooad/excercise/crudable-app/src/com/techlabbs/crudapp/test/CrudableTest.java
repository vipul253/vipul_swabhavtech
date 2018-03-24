 package com.techlabbs.crudapp.test;

import com.techlabs.crudable.*;
import com.techlabbs.crudapp.db.*;

public class CrudableTest {

	public static void main(String[] args) {

		doDbOperation(new CustomerDB());
		doDbOperation(new InvoiceDB());
		doDbOperation(new DepartmentDB());

	}

	public static void doDbOperation(ICrudable crudable) {
		System.out.println("Doing DB operations:");
		crudable.create();
		crudable.read();
		crudable.update();
		crudable.delete();
	}

}
