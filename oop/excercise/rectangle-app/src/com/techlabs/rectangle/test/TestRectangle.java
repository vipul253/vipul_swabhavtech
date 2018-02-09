package com.techlabs.rectangle.test;

import com.techlabs.rectangle.*;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle r1;
		r1 = new Rectangle();

		r1.setWidth(50);
		r1.setHeight(50);
		System.out.println("width r1: " + r1.getWidth() + " height r1: "
				+ r1.getHeight());
		System.out.println("Area is: " + r1.calcArea());

		SerializeDeserializeRect s1 = new SerializeDeserializeRect();
		s1.serialize(r1);

		Rectangle r2 = s1.deserialize();
		System.out.println("width r2: " + r2.getWidth() + " height r2: "
				+ r2.getHeight());
		System.out.println("Area is: " + r2.calcArea());
	}

}
