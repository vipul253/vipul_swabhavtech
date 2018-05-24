package com.techlabs.AutoFactory.test;

import com.techlabs.AutoFactory.*;

public class AutoFactoryTest {

	public static void main(String[] args) {
		AutomobileFactory factory = AutomobileFactory.getInstance();
		
		Automobile auto1 = factory.make(AutoType.AUDI);
		Automobile auto2 = factory.make(AutoType.BMW);
		auto1.start();
		auto1.stop();
		System.out.println(auto1.getClass());
		System.out.println(auto2.getClass());
		

	}

}
