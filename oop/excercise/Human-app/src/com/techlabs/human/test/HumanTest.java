package com.techlabs.human.test;

//divide height by 39.4
import java.util.*;
import com.techlabs.human.*;

public class HumanTest {

	public static void printDetails(Human human) {
		System.out.println("Name:" + human.getName() + " H:"
				+ human.getHeight() + " W:" + human.getWeight() + " Gender:"
				+ human.getGender() + " BMI:" + human.calcBMI() + " Category:"
				+ human.category());
	}

	public static void main(String[] args) {

		Human h1 = new Human("Vipul", 6f, 100f, Gender.MALE);
		Human h2 = new Human("Vipul", Gender.FEMALE);

		//printDetails(h1);
		h1.eat();
		//printDetails(h1);

		//printDetails(h2);
		h2.play();
		//printDetails(h2);
		
		Human[] humans = new Human[3];
		
		humans[0] = new Human("ajay", 5.8f, 101f, Gender.MALE); 
		humans[1] = new Human("vijay", 5.7f, 60.2f, Gender.FEMALE);
		humans[2] = new Human("dijay", 5.9f, 67f, Gender.MALE);
		
		//for (Human h : humans)
			//printDetails(h);
		
		System.out.println(h1);
		System.out.println(h1.toString());
		System.out.println(h1.getName().hashCode());
		System.out.println(h2.getName().hashCode());
		TreeSet<Human> men = new TreeSet<Human>();
		for (Human h : humans)
			men.add(h);
		
	}

}