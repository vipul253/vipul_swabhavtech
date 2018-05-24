package com.techlabs.factory.bmw;

import com.techlabs.auto.factory.Automobile;

class HatchBack implements Automobile {

	@Override
	public void start() {
		System.out.println("BMW hatchback starts");
	}

	@Override
	public void stop() {
		System.out.println("BMW hatchback stops");	
	}

}
