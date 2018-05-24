package com.techlabs.html.dom;

public class Control implements Element {
	private String name;
	
	public Control(String name){
		this.name=name;
	}
	
	public void draw(int indent){
		this.makeIndent(indent);
		System.out.println("<"+this.name+">");
		this.makeIndent(indent);
		System.out.println("</"+this.name+">");
	}
	
	public void makeIndent(int indent){
		for(int i = 0;i<=indent;i++){
			System.out.print("    ");
		}
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
}
