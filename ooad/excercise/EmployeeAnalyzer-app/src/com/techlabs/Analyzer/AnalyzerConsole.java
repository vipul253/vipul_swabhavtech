package com.techlabs.Analyzer;

import java.util.Map;

public class AnalyzerConsole {

	public static void main(String[] args) {

		EmployeeAnalyzer analyzer = new EmployeeAnalyzer();
		// for(Employee emp : EmployeeList){
		// System.out.println(emp.toString());
		// }
		// System.out.println(analyzer.getMaxSalariedEmployee(EmployeeList));
		//System.out.println(analyzer.DesignationCounts());
		for (Map.Entry<String, Integer> entry : analyzer.getDesignationCounts().entrySet()) {
			System.out.print(entry+"\n");
		}
		
	}
}
