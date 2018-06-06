package com.techlabs.facade;

class Iphone implements SmartPhone{
	
	@Override
	public void modelName() {
		System.out.println("Iphone 7s");
	}
	@Override
	public void price() {
		System.out.println("Rs 70000.00");
		
	}
}
