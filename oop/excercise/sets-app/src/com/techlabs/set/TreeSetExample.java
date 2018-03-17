package com.techlabs.set;

import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String args[]) {

		TreeSet<String> tset = new TreeSet<String>();

		tset.add("ABC");
		tset.add("String");
		tset.add("Test");
		tset.add("Pen");
		tset.add("Ink");
		tset.add("Jack");
		tset.add("Jack");

		for(String i:tset)
			System.out.println(i);
		TreeSet<Integer> tset2 = new TreeSet<Integer>();
		
		tset2.add(222);
		tset2.add(88);
		tset2.add(7);
		tset2.add(101);
		tset2.add(0);
		tset2.add(3);
		
		System.out.println(tset2);
		tset2.remove(88);
		System.out.println(tset2);
		System.out.println(tset2.size());
		tset.clear();
		System.out.println(tset);
	}
}