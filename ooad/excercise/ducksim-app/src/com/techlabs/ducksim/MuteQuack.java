package com.techlabs.ducksim;

import com.techlabs.duck_interface.QuackBehavior;

public class MuteQuack implements QuackBehavior {
	public void quack(){
		System.out.println("no sound");
	}
}
