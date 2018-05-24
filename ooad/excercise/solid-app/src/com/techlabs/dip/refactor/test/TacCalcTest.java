package com.techlabs.dip.refactor.test;

import com.techlabs.dip.refactor.*;

public abstract class TacCalcTest {

	public static void main(String[] args) {

		CalculateTax calci1 = new CalculateTax(new EmailLogger());
		CalculateTax calci2 = new CalculateTax(new XmlLogger());

		calci1.calcTax(1, 0);
		calci2.calcTax(1, 0);
	}

}
