package com.techlabs.circle;

public class Circle {
	private float radius;
	private float PI = 3.14f;
	
	public void setRadius(float pradius) {
		radius = pradius;
	}
	
	public float getRadius() {
		return radius;
	}
	
	public float CalcArea() {
		
		float area= 2*PI*this.radius;
		return area;
	}
	
}
