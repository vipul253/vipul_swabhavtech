package com.techlabs.dogdoor;

import java.util.ArrayList;

public class Bark {
	private String sound;
	
	public String getSound(){
		return sound;
		
	}
	
	@Override
	public boolean equals(Object bark){
		if(bark instanceof(Bark)){
			Bark otherBark=(Bark)bark;
		}
		
	}
}
