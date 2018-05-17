package com.techlabs.isp.voilation;

public class Robot implements IWorker{
	@Override
	public void startWork(){
		System.out.println("robot starts working");
	}
	
	@Override
	public void stopWork(){
		System.out.println("robot stops working");
	}
	
	@Override
	public void startEating() {
		throw new RuntimeException("Robots can't eat");
	}
	
	@Override
	public void stopEating(){
		throw new RuntimeException("Robots can't eat");
	}
}
