package com.techlabs.factory.bmw;

import com.techlabs.auto.factory.AutoFactory;
import com.techlabs.auto.factory.Automobile;

public class BmwFactory implements AutoFactory {

	@Override
	public Automobile makeHatchBack() {
		return new HatchBack();
	}

	@Override
	public Automobile makeSedan() {
		return new Sedan();
	}

	@Override
	public Automobile makeSUV() {
		return new SUV();
	}

}
