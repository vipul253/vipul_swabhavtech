package com.techlabs.Analyzer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.techlabs.DataLoader.*;
import com.techlabs.Employee.Employee;

public class EmployeeAnalyzer {

	EmployeeParser parser = new EmployeeParser(new WEBLoader(
			"https://swabhav-tech.firebaseapp.com/emp.txt"));
	// EmployeeParser parser = new EmployeeParser(new
	// FileLoader("Data/data.txt"));

	HashSet<Employee> employeeList = parser.getEmpList();

	public Employee getMaxSalariedEmployee() {
		int maxSalary = 0;
		Employee employee = null;
		for (Employee emp : employeeList) {
			if (maxSalary < emp.getSalary()) {
				maxSalary = emp.getSalary();
				employee = emp;
			}
		}
		return employee;
	}

	public int getCountByDesignation(String designation) {
		int count = 0;
		for (Employee employee : employeeList) {
			if (employee.getDesignation().equalsIgnoreCase(designation))
				count++;
		}
		return count;
	}

	public Map<String, Integer> getDesignationCounts() {
		Map<String, Integer> empByDesignation = new HashMap<String, Integer>();
		for (Employee emp : employeeList) {
			int count = getCountByDesignation(emp.getDesignation());
			empByDesignation.put(emp.getDesignation(), count);
		}
		return empByDesignation;
	}
}
