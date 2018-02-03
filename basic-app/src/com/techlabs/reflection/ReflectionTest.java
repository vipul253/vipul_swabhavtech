package com.techlabs.reflection;

public class ReflectionTest {

	public static void main(String[] args) {
		GetMethods gm1 = new GetMethods();
		GetConstructor gc1 = new GetConstructor();
		
		gm1.printMethods("java.lang.System");
		gc1.printConstructor("java.lang.Object");

	}

}
