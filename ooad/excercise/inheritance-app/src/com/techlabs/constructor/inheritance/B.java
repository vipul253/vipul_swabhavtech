package com.techlabs.constructor.inheritance;


public class B extends A {
	public B(){
		super(10);
		System.out.println("constructor B");
	}
	public B(int foo) {
		super(foo);
		System.out.println("constructor B");
	}
}
