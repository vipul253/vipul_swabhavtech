package com.techlabs.auto.factory;

public interface AutoFactory {
	
	Automobile makeHatchBack(); //factory method
	Automobile makeSedan();
	Automobile makeSUV();
	
}
