package com.techlabs.factory.toyota;

import com.techlabs.auto.factory.Automobile;

class ToyotaSedan implements Automobile {
	@Override
	public void start() {
		System.out.println("Toyota sedan starts");
	}

	@Override
	public void stop() {
		System.out.println("Toyota sedan stops");
	}
}
