package com.techlabs.AutoFactory;

public class BmwFactory implements AutoFactory {

	@Override
	public Automobile make() {
		return new BMW();
	}

}
