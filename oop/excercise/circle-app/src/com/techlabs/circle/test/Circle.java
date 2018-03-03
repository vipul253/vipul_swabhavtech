package com.techlabs.circle.test;

public class Circle {
	private float radius;
	private float PI = 3.14f;
	private String color = "red";

	public void setRadius(float pradius) {
		radius = pradius;
	}

	public void setColor(String pcolor) {
		if (pcolor.equalsIgnoreCase("red") || pcolor.equalsIgnoreCase("green")
				|| pcolor.equalsIgnoreCase("blue")) {
			this.color = pcolor.toLowerCase();
		}
	}

	public float getRadius() {
		return radius;
	}

	public String getColor() {
		return color;
	}

	public float CalcArea() {

		float area = 2 * PI * this.radius;
		return area;
	}

}
