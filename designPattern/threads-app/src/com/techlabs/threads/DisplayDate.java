package com.techlabs.threads;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DisplayDate {
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Calendar cal = Calendar.getInstance();
	
	public void displayDate(){
		while(true){
			System.out.println(dateFormat.format(cal.getTime()));
		}
	}
}
