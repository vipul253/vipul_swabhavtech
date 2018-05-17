package com.techlabs.lsp.voilation;

public class Square extends Rectangle {
	
	public Square(int side){
		super(side,side);
	}
	
	@Override
	public void setWidth(int width){
		this.height=this.width=width;
	}
	
	public void setHeight(int height){
		this.width=this.height=height;
	}
}
