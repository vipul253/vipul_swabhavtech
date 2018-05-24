package com.techlabs.dip.voilation.test;

import com.techlabs.dip.voilation.CalculateTax;
import com.techlabs.dip.voilation.LoggerType;

public class TaxCalcTest {

	public static void main(String[] args) {
		CalculateTax calci = new CalculateTax(LoggerType.EMAIL);
		calci.calcTax(10, 1);
		calci.calcTax(1, 0);

	}

}
