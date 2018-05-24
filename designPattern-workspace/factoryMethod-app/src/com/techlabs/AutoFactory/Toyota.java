package com.techlabs.AutoFactory;

class Toyota implements Automobile {

	@Override
	public void start() {
		System.out.println("Toyota starts");
	}

	@Override
	public void stop() {
		System.out.println("Toyota stops");
	}

}
