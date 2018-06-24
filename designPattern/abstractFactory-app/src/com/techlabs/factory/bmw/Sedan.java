package com.techlabs.factory.bmw;

import com.techlabs.auto.factory.Automobile;

class Sedan implements Automobile{
	@Override
	public void start() {
		System.out.println("BMW sedan starts");
	}

	@Override
	public void stop() {
		System.out.println("BMW sedan stops");
	}
}
