package com.techlabs.basic;

public class AgeExceptionTest {
	
	private String name;
	private int age;
	
	public AgeExceptionTest(String name,int age) throws InvalidAgeException {
		if (age < 0) {
			throw new InvalidAgeException("Entered Invalid age: " + age);
		}
		else {
			this.name=name;
			this.age=age;
			System.out.println("created Human");
		}
	}
	
	public void disp(){
		System.out.println("Name: "+this.name);
		System.out.println("age: "+this.age);
		
	}
}
