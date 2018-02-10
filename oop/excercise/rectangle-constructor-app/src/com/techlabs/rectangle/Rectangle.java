package com.techlabs.rectangle;

public class Rectangle {

	private final int width;
	private final int height;
	private BorderStyleOption border;

	public Rectangle(int width, int height) {
		this.height = height;
		this.width = width;
	}

	public Rectangle(int width, int height, BorderStyleOption border) {
		this.height = height;
		this.width = width;
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

}
