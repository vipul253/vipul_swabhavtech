package com.techlabs.interfacePolymorph.test;

import com.techlabs.polymorphInterface.*;
import com.techlabs.human.*;

public class InterfacePolymorphTest {
	
	public static void main(String args[]){
		Man man = new Man();
		Boy boy = new Boy();
		
		atTheParty(man);
		atTheParty(boy);
		
		atTheCinema(boy);
		atTheCinema(man);
	}
	
	public static void atTheParty(Honorable obj){
		System.out.println("at the party");
		obj.wish();
		obj.depart();
		
	}
	
	public static void atTheCinema(Emotional obj){
		System.out.println("at the Cinema");
		obj.cry();
		obj.laugh();
	}
	
}

