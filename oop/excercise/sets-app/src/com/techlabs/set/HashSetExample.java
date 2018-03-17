package com.techlabs.set;

import java.util.*;

public class HashSetExample {

	public static void main(String args[]) {
		
		HashSet<String> hset = new HashSet<String>();

		hset.add("Mango");
		hset.add("Apple");
		hset.add("Mango");
		hset.add(null);
		hset.add(null);

		for (String i : hset)
			System.out.println(i);
		hset.remove(null);
		
		System.out.println(hset);
		System.out.println(hset.size());
		hset.clear();
		System.out.println(hset);
	}

}
