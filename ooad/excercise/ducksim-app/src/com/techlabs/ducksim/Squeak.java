package com.techlabs.ducksim;

import com.techlabs.duck_interface.QuackBehavior;

public class Squeak implements QuackBehavior{
	public void quack(){
		System.out.println("squeak");
	}
}
