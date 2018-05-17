package com.techlabs.lsp.refactor;

public class Square implements Polygon {
	private int side;
	
	public Square(int side){
		this.side=side;
	}
	
	@Override
	public int calcArea(){
		return side*side;
	}
	
	public void setSide(int side){
		this.side=side;
	}
	
	public int getSide(){
		return side;
	}
}
