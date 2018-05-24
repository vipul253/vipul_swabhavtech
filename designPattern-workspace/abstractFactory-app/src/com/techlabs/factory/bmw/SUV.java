package com.techlabs.factory.bmw;

import com.techlabs.auto.factory.Automobile;

class SUV implements Automobile {
	
	@Override
	public void start() {
		System.out.println("BMW SUV starts");
	}

	@Override
	public void stop() {
		System.out.println("BMW SUV stops");
	}
}
