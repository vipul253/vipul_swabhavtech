package com.techlabs.factory.audi;

import com.techlabs.auto.factory.Automobile;

class Audi10 implements Automobile {

	@Override
	public void start() {
		System.out.println("Audi10 starts");
	}

	@Override
	public void stop() {
		System.out.println("Audi10 stops");
	}

}
