package com.techlabs.factory.toyota;

import com.techlabs.auto.factory.Automobile;

class ToyotaHatchBack implements Automobile {

	@Override
	public void start() {
		System.out.println("Toyota Hatchback starts");
	}

	@Override
	public void stop() {
		System.out.println("Toyota hatchback stops");
	}

}
