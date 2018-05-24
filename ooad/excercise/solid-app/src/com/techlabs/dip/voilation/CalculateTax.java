package com.techlabs.dip.voilation;

public class CalculateTax {

	private LoggerType logger;
	public CalculateTax(LoggerType logger){
		this.logger=logger;
	}
	
	public int calcTax(int a, int b) {
		int x=0;
		try {
			x = a / b;
		} catch (Exception e) {
			if (logger.equals(LoggerType.EMAIL))
				new EmailLogger().setLog(e.toString());
			else if (logger.equals(LoggerType.XML))
				new XmlLogger().setLog(e.toString());
		}
		return x;
	}
}
