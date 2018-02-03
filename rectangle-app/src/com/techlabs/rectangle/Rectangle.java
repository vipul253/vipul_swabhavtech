package com.techlabs.rectangle;

public class Rectangle {
	private int width;
	private int height;

	public int calcArea() {
		return width * height;
	}

	private int convertToValid(int val) {
		if (val < 10) {
			return 10;
		} else if (val >= 100) {
			return 100;
		} else {
			return val;
		}
	}

	public void setWidth(int pwidth) {
		width = convertToValid(pwidth);
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int pheight) {
		height = convertToValid(pheight);
	}

	public int getHeight() {
		return height;
	}
}
