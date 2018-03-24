package com.techlabs.constructor.inheritance;

public class A {
	private int foo;
	public A(int foo){
		this.foo=foo;
		System.out.println("constructor A, foo is "+this.getFoo());
	}
	public int getFoo(){
		return foo;
	}
}
