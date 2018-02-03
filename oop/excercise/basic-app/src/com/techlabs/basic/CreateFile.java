package com.techlabs.basic;
import java.io.*;

public class CreateFile {
	
	public void create(String filename) {
	try {
	     File file = new File("data/"+filename);
	     if (file.createNewFile()){
	          System.out.println("File created successfully");
	    }
	     else{
	          System.out.println("File already present");
	    }
   	} catch (IOException e) {
   		System.out.println("Exception Occurred:" + e);
   		}
	}
}
