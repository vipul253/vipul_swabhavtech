package com.techlabs.ducksim;

public class MallardDuck extends Duck {
	
	public MallardDuck(){
	quackBehavior = new Quack();
	flyBehavior = new FlyWithWings();
	}
	
	public void display(){
		System.out.println("I am a Mallard Duck");
	}
	
}
