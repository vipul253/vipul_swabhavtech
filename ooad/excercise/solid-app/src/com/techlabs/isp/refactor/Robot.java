package com.techlabs.isp.refactor;

public class Robot implements Workable {
	@Override
	public void startWork(){
		System.out.println("robot starts working");
	}
	
	@Override
	public void stopWork(){
		System.out.println("robot stops working");
	}
}
