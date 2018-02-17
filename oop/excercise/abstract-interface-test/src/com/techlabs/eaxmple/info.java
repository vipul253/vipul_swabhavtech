package com.techlabs.eaxmple;

public abstract class info {
	private String name;
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public abstract void printInfo();
	
}
