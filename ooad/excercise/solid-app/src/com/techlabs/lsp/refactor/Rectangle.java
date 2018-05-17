package com.techlabs.lsp.refactor;

public class Rectangle implements Polygon {
	
	private int height;
	private int width;
	
	public Rectangle(int height,int width){
		this.height=height;
		this.width=width;
	}
	
	@Override
	public int calcArea(){
		return width*height;
	}
	
	public void setHeight(int height){
		this.height=height;
	}
	
	public void setWidth(int width){
		this.width=width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
}