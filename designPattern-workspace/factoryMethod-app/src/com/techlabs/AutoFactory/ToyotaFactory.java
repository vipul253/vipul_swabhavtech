package com.techlabs.AutoFactory;

public class ToyotaFactory implements AutoFactory {

	@Override
	public Automobile make() {
		return new Toyota();
	}
	
}
