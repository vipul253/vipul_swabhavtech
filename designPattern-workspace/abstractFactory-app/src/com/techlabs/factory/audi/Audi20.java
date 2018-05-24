package com.techlabs.factory.audi;

import com.techlabs.auto.factory.Automobile;

class Audi20 implements Automobile {

	@Override
	public void start() {
		System.out.println("Audi20 starts");
	}

	@Override
	public void stop() {
		System.out.println("Audi20 stops");
	}

}
