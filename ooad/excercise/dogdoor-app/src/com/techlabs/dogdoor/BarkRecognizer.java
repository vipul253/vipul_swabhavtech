package com.techlabs.dogdoor;

import java.util.*;

public class BarkRecognizer {
	private DogDoor door;

	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}

	public void recognize(Bark bark) {
		System.out.println("BarkRecognizer: Heard a'" + bark.getSound() + "'");
		LinkedList<Bark> allowedBarks = door.getAllowedBarks();
		for (Iterator<Bark> i = allowedBarks.iterator(); i.hasNext();) {
			Bark allowedBark = (Bark) i.next();
			if (allowedBark.equals(bark)) {
				door.open();
				return;
			}
		}
		System.out.println("This dog is not allowed.");
	}

}