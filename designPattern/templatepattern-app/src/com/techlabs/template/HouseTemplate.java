package com.techlabs.template;

public abstract class HouseTemplate {

	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.\n");
	}

	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}

	public abstract void buildWalls();
	public abstract void buildPillars();

	private void buildFoundation() {
		System.out.println("Building foundation");
	}
}