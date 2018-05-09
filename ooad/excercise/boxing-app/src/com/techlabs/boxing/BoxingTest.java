package com.techlabs.boxing;

import java.util.*;

public class BoxingTest {

	public static void main(String[] args) {

        Integer i = new Integer(10);
 
        int i1 = i;
 
        System.out.println("Value of i: " + i);
        System.out.println("Value of i1: " + i1);
        System.out.println("value of i2:"+Integer.valueOf(i));
 
        Character chr = 'a';
        
        char ch = chr;
        
        System.out.println("Value of ch: " + ch);
        System.out.println("Value of gfg: " + chr);
        
        List<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < 10; j++)
            list.add(j);
        
        for(Integer k: list)
        	System.out.print(" "+Integer.valueOf(k));

        
        List ints = new ArrayList();
        ints.add(new Integer(5));
        ints.add(6);
        System.out.println("\n"+ints);

	}

}
