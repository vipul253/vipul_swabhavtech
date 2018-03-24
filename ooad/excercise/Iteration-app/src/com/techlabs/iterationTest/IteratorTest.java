package com.techlabs.iterationTest;

import com.techlabs.iterate.customList;
import java.util.*;
public class IteratorTest {

	public static void main(String[] args) {
		customList c1 = new customList(1,10);
		Iterator<Integer> i = c1.iterator();
		while(i.hasNext()){
			int n = i.next();
			System.out.println(n);
		}
		
		for(Integer n : c1){
			System.out.println(n);
		}
	}

}
