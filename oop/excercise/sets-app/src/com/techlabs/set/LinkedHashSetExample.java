package com.techlabs.set;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
	public static void main(String args[]) {

		LinkedHashSet<String> lhset = new LinkedHashSet<String>();

		lhset.add("vipul");
		lhset.add("ajay");
		lhset.add("vijay");
		lhset.add("abcd");
		lhset.add("qwer");
		lhset.add("qwer");
		System.out.println(lhset);
		lhset.remove("qwer");
		System.out.println(lhset);
		System.out.println(lhset.size());
		LinkedHashSet<Integer> lhset2 = new LinkedHashSet<Integer>();
		
		lhset2.add(0);
		lhset2.add(32);
		lhset2.add(7);
		lhset2.add(67);
		lhset2.add(89);
		System.out.println(lhset2);
		lhset2.remove(67);
		System.out.println(lhset2);
		System.out.println(lhset2.size());
		lhset.clear();
		System.out.println(lhset);
	}
}