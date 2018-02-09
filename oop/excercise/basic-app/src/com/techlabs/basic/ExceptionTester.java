package com.techlabs.basic;

public class ExceptionTester {

	public static void main(String[] args) {
		try {
			AgeExceptionTest h1 = new AgeExceptionTest("vipul", -3);
			h1.disp();
		} catch (InvalidAgeException iex) {
			System.out.println(iex.getMessage());
		}

	}

}
