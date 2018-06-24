package com.techlabs.template.test;

import com.techlabs.template.ConcreteHouse;
import com.techlabs.template.HouseTemplate;
import com.techlabs.template.WoodenHouse;

public class HouseBuildTest {

	public static void main(String[] args) {
		
		HouseTemplate wooden = new WoodenHouse();
		HouseTemplate concrete = new ConcreteHouse();
		
		wooden.buildHouse();
		concrete.buildHouse();

	}

}
