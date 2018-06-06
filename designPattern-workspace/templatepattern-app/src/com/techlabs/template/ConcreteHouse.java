package com.techlabs.template;

public class ConcreteHouse extends HouseTemplate {
	
	@Override
	public void buildWalls() {
		System.out.println("Building Concrete Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Concrete pillars");
	}
}
