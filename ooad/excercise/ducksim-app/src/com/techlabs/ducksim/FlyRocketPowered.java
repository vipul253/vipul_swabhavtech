package com.techlabs.ducksim;

import com.techlabs.duck_interface.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("I fly with a rocket");

	}
}
