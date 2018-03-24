package com.techlabs.human;

import com.techlabs.polymorphInterface.Emotional;
import com.techlabs.polymorphInterface.Honorable;

public class Boy implements Emotional,Honorable{
	
	public void cry(){
		System.out.println("crying");
	}
	
	public void laugh(){
		System.out.println("laughing");
	}
	
	public void wish(){
		System.out.println("wishing");
	}
	
	public void depart(){
		System.out.println("departing");
	}
}
