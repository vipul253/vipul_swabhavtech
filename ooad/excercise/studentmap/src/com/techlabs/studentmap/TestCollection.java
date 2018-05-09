package com.techlabs.studentmap;

import java.util.ArrayList;

public class TestCollection {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student(122,10,"vipul"));
		list.add(new Student(122,11,"newu"));
		list.add("asdfg");
		
		for(Object j : list){
			Student t =(Student)j;
			System.out.println(t);
		}
	}
	
}
