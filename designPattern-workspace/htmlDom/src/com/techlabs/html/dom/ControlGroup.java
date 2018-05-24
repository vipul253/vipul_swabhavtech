package com.techlabs.html.dom;

import java.util.*;

public class ControlGroup implements Element {
	private String name;
	private List<Element> content;
	
	public ControlGroup(String name){
		this.name=name;
		content = new ArrayList<Element>();
	}
	
	public void add(Element e) {
		content.add(e);
	}
	
	public void draw(int indent){
		this.makeIndent(indent);
		System.out.println("<"+this.name+">");
		for(Element e:this.content){
			if(e instanceof ControlGroup){
				e.draw(indent+1);
			}
			else{
				e.draw(indent);
			}
		}
		this.makeIndent(indent);
		System.out.println("</"+this.name+">");
		
	}
	
	public void makeIndent(int indent){
		for(int i = 0;i<indent;i++){
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
