package com.techlabs.rectangle.test;

import com.techlabs.rectangle.*;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle r1;
		r1 = new Rectangle();
		
		r1.setWidth(50);
		r1.setHeight(50);
		System.out.println("Area is: " + r1.calcArea());
		System.out.println("width: "+r1.getWidth()+" height: "+r1.getHeight());
	}

}
