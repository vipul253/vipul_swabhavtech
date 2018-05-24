package com.techlabs.dip.refactor;

public class EmailLogger implements Logger {

	public void setLog(String errormsg) {
		System.out.println("the error " + errormsg + " has been mailed");
	}
}
