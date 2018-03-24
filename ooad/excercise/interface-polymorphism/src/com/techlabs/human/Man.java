package com.techlabs.human;

import com.techlabs.polymorphInterface.Honorable;

public class Man implements Honorable {
	
	@Override
	public void wish() {
		System.out.println("wishing");
	}

	@Override
	public void depart() {
		System.out.println("departing");
	}
}
