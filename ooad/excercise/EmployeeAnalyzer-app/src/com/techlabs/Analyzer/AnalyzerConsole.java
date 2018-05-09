package com.techlabs.Analyzer;

import java.util.HashSet;

import com.techlabs.DataLoader.*;
import com.techlabs.Employee.*;

public class AnalyzerConsole {

	public static void main(String[] args) {

		EmployeeAnalyzer analyzer = new EmployeeAnalyzer();
		EmployeeParser parser = new EmployeeParser(new WEBLoader(
				"https://swabhav-tech.firebaseapp.com/emp.txt"));
		HashSet<Employee> EmployeeList = parser.getEmpList();
		// for(Employee emp : EmployeeList){
		// System.out.println(emp.toString());
		// }

		//System.out.println(analyzer.getMaxSalariedEmployee(EmployeeList));
		System.out.println("Manager count:"+analyzer.getNumberOfEmployeesByDesignation(EmployeeList,"manager"));
		System.out.println("Analyst count:"+analyzer.getNumberOfEmployeesByDesignation(EmployeeList,"analyst"));
		System.out.println("Salesman count:"+analyzer.getNumberOfEmployeesByDesignation(EmployeeList,"salesman"));
		System.out.println("Clerk count:"+analyzer.getNumberOfEmployeesByDesignation(EmployeeList,"clerk"));
		
	}
}
