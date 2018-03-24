package com.techlabs.employee.test;

import com.techlabs.employee.*;

public class EmployeeSalaryTest {

	public static void main(String[] args) {

		Employee emp1 = new Manager(1, "vipul", 25000);
		Employee emp2 = new Developer(2, "neiu", 23000);
		Employee emp3 = new Analyst(3, "neiume", 24000);

		EmployeePaySlip PaySlip = new EmployeePaySlip();
		PaySlip.printPaySlip(emp1);
		PaySlip.printPaySlip(emp2);
		PaySlip.printPaySlip(emp3);
	}

}
