package com.techlabs.AutoFactory;

public class AudiFactory implements AutoFactory {

	@Override
	public Automobile make() {
		return new Audi();
	}
	
}
