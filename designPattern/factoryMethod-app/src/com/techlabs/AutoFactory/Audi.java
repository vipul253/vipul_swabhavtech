package com.techlabs.AutoFactory;

class Audi implements Automobile {

	@Override
	public void start() {
		System.out.println("Audi starts");
	}

	@Override
	public void stop() {
		System.out.println("Audi stops");
	}

}
