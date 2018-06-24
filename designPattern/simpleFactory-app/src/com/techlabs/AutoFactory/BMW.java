package com.techlabs.AutoFactory;

class BMW implements Automobile {

	@Override
	public void start() {
		System.out.println("BMW starts");
	}

	@Override
	public void stop() {
		System.out.println("BMW stops");	
	}

}
