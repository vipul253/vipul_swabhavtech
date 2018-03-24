package com.techlabs.human;

import com.techlabs.polymorphInterface.*;

public class Boy implements Emotional, Honorable {

	@Override
	public void cry() {
		System.out.println("crying");
	}

	@Override
	public void laugh() {
		System.out.println("laughing");
	}

	@Override
	public void wish() {
		System.out.println("wishing");
	}

	@Override
	public void depart() {
		System.out.println("departing");
	}
}
