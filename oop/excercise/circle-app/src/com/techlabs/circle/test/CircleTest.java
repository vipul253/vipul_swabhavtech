package com.techlabs.circle.test;

import com.techlabs.circle.*;

public class CircleTest {

	public static void main(String[] args) {

		Circle c1 = new Circle();
		Circle c2 = new Circle();

		c1.setRadius(1.5f);
		c2.setRadius(3.5f);
		float areac1 = c1.CalcArea();
		float areac2 = c2.CalcArea();

		System.out.println("Circle 1:\n" + "radius: " + c1.getRadius()
				+ " Area: " + areac1);
		System.out.println("Circle 2:\n" + "radius: " + c1.getRadius()
				+ " Area: " + areac2);

	}

}
