package com.techlabs.factory.audi;

import com.techlabs.auto.factory.Automobile;

class Audi30 implements Automobile {

	@Override
	public void start() {
		System.out.println("Audi starts");
	}

	@Override
	public void stop() {
		System.out.println("Audi stops");
	}
}
