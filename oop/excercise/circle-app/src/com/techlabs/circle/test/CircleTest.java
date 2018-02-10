package com.techlabs.circle.test;

import com.techlabs.circle.*;

public class CircleTest {

	private static void printDetails(Circle obj) {
		System.out.println("\nradius:" + obj.getRadius() + " Area:"
				+ obj.CalcArea() + " color: " + obj.getColor());
		System.out.println("hash code is :" + obj.hashCode());

	}

	public static void main(String[] args) {

		Circle c1 = new Circle();
		Circle c2 = new Circle();

		c1.setRadius(1.5f);
		c2.setRadius(3.5f);
		c1.setColor("blue");
		// printDetails(c1);
		// printDetails(c2);

		Circle temp = c1;
		// System.out.println(temp.getRadius());
		temp.setRadius(1.0f);
		// System.out.println(temp.getRadius());
		// System.out.println(c1.getRadius());
		// printDetails(temp);
		// printDetails(c1);

		Circle c3 = new Circle();
		c3.setColor("GREEN");
		//printDetails(c3);
		
		//Annonymous Object
		printDetails(new Circle());
		new Circle().setColor("green");
		System.out.println(new Circle().getColor());
	}

}
