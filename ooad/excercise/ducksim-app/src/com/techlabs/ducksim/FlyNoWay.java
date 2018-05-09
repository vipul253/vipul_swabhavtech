package com.techlabs.ducksim;

import com.techlabs.duck_interface.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
	public void fly(){
		System.out.println("I can't fly");
	}
	
}
