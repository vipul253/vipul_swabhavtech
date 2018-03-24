package com.techlabs.dogdoor.test;

import com.techlabs.dogdoor.*;

public class DogDoorSimulator {

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		BarkRecognizer recognizer = new BarkRecognizer(door);
		Remote remote = new Remote(door);

		System.out.println("Fido barks to go outside...");
		recognizer.recognize("woof");

		System.out.println("Fido has gone outside...");

		System.out.println("Fido's all done....");
		try {
			Thread.currentThread();  
			Thread.sleep(9000);
		} catch (InterruptedException e) {
		}
		System.out.println("..but he is stuck outside");
		System.out.println("fido starts barking....");
		recognizer.recognize("woof");
		System.out.println("Fido's back inside...");

	}

}
