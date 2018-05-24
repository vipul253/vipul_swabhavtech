package com.techlabs.factory.audi;

import com.techlabs.auto.factory.AutoFactory;
import com.techlabs.auto.factory.Automobile;

public class AudiFactory implements AutoFactory {

	@Override
	public Automobile makeHatchBack() {
		return new Audi10();
	}

	@Override
	public Automobile makeSedan() {
		return new Audi20();
	}

	@Override
	public Automobile makeSUV() {
		return new Audi30();
	}
}
