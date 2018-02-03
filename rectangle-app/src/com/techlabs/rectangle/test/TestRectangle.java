package com.techlabs.rectangle.test;

import com.techlabs.rectangle.*;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle r1;
		r1 = new Rectangle();
		
		r1.width = 10;
		r1.height= 20;
		System.out.println("Area is: " + r1.calcArea());
	}

}
