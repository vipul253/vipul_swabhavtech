package com.techlabs.bugs;

public class TestStackTrace {
	public static void main(String args[]){
		try {
		m1();
		}catch(Exception ex){ex.printStackTrace();}
		
		System.out.println("end of main");
	}
	
	public static void m1() throws Exception{
		System.out.println("inside m1");
		m2();
	}
	
	public static void m2() throws Exception{
		System.out.println("inside m2");
		m3();
	}
	
	public static void m3() throws Exception{
		throw new Exception(" inside m3 ");
	}
}
