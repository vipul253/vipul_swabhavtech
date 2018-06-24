package com.techlabs.facade;

class Windows implements SmartPhone {
	@Override
	public void modelName() {
		System.out.println("Windows phone 8");
	}
	@Override
	public void price() {
		System.out.println("Rs 10000.00");
		
	}
}
