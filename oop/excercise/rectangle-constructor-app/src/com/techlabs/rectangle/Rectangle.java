package com.techlabs.rectangle;

public class Rectangle {

	private final int width;
	private final int height;
	private BorderStyleOption border;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(int width, int height, BorderStyleOption border) {
		this(width, height);
		this.border = border;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public BorderStyleOption getBorder() {
		return border;
	}

	public int calcArea() {
		return width * height;
	}

}
