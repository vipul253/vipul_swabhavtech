package com.techlabs.dip.refactor;

public class CalculateTax {
	private Logger logger;
	
	public CalculateTax(Logger logger){
		this.logger=logger;
	}
	
	public int calcTax(int a, int b) {
		int x=0;
		try {
			x = a / b;
		} catch (Exception e) {
			logger.setLog(e.toString());
		}
		return x;
	}
}
