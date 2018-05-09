package com.techlabs.map;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {

		Map<Integer, String> list1 = new HashMap<Integer, String>();
		Map<Integer, String> list2 = new LinkedHashMap<Integer, String>();
		Map<Integer, String> list3 = new TreeMap<Integer, String>();

		for (int i = 1; i <= 10; i++) {
			String alphabet = String.valueOf((char) ('a' + i - 1));
			list1.put(i, alphabet);
			list2.put(i, alphabet);
			list3.put(i, alphabet);
		}

	    for(Iterator<Map.Entry<Integer, String>> it = list2.entrySet().iterator(); it.hasNext(); ) {
	        Map.Entry<Integer, String> entry = it.next();
	        if(entry.getKey().equals(2)) {
	          it.remove();
	        }
	    }
	    
	    list3.put(3, "new");
	    list2.put(4, "new");
	    
		for (Map.Entry<Integer, String> entry : list1.entrySet()) {
			System.out.print(" "+entry);
		}
		System.out.println();
		for (Map.Entry<Integer, String> entry : list2.entrySet()) {
			System.out.print(" "+entry);
		}
		System.out.println();
		for (Map.Entry<Integer, String> entry : list3.entrySet()) {
			System.out.print(" "+entry);
		}
	}
}
