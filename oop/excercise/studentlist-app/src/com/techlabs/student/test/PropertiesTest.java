package com.techlabs.student.test;

import java.util.*;
import java.io.*;

public class PropertiesTest {

	public static void main(String[] args) throws Exception {

		FileReader reader = new FileReader("data/student.properties");
		Properties p = new Properties();
		p.load(reader);

		System.out.println(p.getProperty("firstName"));
		System.out.println(p.getProperty("age"));

		p.setProperty("email", "vipul@techlabs.com");
		p.store(new FileWriter("data/student.properties"),
				"added new property!");

		System.out.println(p.getProperty("email"));
	}

}
