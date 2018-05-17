package com.techlabs.isp.refactor;

public class Manager implements WorkableEatable {
	
	@Override
	public void startWork(){
		System.out.println("manager starts working");
	}
	
	@Override
	public void stopWork(){
		System.out.println("manager stops working");
	}
	
	@Override
	public void startEating(){
		System.out.println("manager starts eating");
	}
	
	@Override
	public void stopEating(){
		System.out.println("manager stops eating");
	}
}
