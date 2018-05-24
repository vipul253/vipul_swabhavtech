package com.techlabs.dataservice;

public enum DataService {
	
	INSTANCE;
	
	private DataService(){
		System.out.println("instance created");
	}
	
	public void doProcessing() {
		System.out.println(this.hashCode()+" is processing");
	}
}
