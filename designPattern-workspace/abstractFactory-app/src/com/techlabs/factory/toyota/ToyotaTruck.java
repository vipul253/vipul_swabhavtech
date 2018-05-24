package com.techlabs.factory.toyota;

import com.techlabs.auto.factory.Automobile;

class ToyotaTruck implements Automobile{
	@Override
	public void start() {
		System.out.println("Toyota Truck starts");
	}

	@Override
	public void stop() {
		System.out.println("Toyota Truck stops");
	}
}
