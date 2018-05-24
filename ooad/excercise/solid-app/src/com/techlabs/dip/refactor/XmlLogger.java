package com.techlabs.dip.refactor;

public class XmlLogger implements Logger {
	public void setLog(String errormsg) {
		System.out.println("the error "+errormsg + " has been logged in XML");
	}
}
