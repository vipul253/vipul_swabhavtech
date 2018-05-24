package com.techlabs.factory.toyota;

import com.techlabs.auto.factory.*;

public class ToyotaFactory implements AutoFactory {

	@Override
	public Automobile makeHatchBack() {
		return new ToyotaHatchBack();
	}

	@Override
	public Automobile makeSedan() {
		return new ToyotaSedan();
	}

	@Override
	public Automobile makeSUV() {
		return new ToyotaTruck();
	}


	
}
