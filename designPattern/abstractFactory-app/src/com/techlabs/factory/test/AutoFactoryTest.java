package com.techlabs.factory.test;

import java.io.*;
import java.util.*;
import com.techlabs.auto.factory.*;
import com.techlabs.factory.bmw.*;

public class AutoFactoryTest {

	public static void main(String[] args) {

		AutoFactory factory1 = new BmwFactory();
		AutoFactory factory2 = createFactory();
		Automobile auto1 = factory1.makeHatchBack();
		Automobile auto2 = factory2.makeSedan();

		auto1.start();
		auto1.stop();
		auto2.start();
		auto2.stop();
		System.out.println(auto1.getClass());
		System.out.println(auto2.getClass());
	}

	public static AutoFactory createFactory() {
		AutoFactory factory = null;
		try {
			FileReader in = new FileReader("data/factory.properties");
			Properties property = new Properties();
			property.load(in);
			String key = property.getProperty("factory2create");
			@SuppressWarnings("unchecked")
			Class<AutoFactory> temp = (Class<AutoFactory>) Class.forName(key);
			factory = temp.newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
		return factory;
	}
}
