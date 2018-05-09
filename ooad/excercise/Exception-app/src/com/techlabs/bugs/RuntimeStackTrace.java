package com.techlabs.bugs;

public class RuntimeStackTrace {

	public static void main(String[] args) {
		try {
			m1();
		} catch (Exception rex) {
			rex.printStackTrace();
		}
		System.out.println("end of main");

	}

	public static void m1() {
		System.out.println("inside m1");
		m2();
	}

	public static void m2() {
		System.out.println("inside m2");
		m3();
	}

	public static void m3() {
		throw new RuntimeException(" inside m3 ");
	}
}
