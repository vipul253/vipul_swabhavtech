package com.techlabs.lsp.voilation;

public class Rectangle {
	protected int height;
	protected int width;
	
	public Rectangle(int height,int width){
		this.height=height;
		this.width=width;
	}
	
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
