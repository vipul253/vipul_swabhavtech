package com.techlabs.ducksim;

import com.techlabs.duck_interface.QuackBehavior;

public class Quack implements QuackBehavior {
	public void quack(){
		System.out.println("I quack");
	}
}
