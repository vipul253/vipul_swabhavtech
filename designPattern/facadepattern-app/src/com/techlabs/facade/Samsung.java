package com.techlabs.facade;

class Samsung implements SmartPhone {
	
	@Override
	public void modelName() {
		System.out.println("Samsung Galaxy S8");	
	}

	@Override
	public void price() {
		System.out.println("Rs 80000.00");	
	}
	

}
