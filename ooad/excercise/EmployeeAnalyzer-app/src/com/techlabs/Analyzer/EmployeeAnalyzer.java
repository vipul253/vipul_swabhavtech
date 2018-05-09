package com.techlabs.Analyzer;

import java.util.HashSet;
import com.techlabs.Employee.Employee;

public class EmployeeAnalyzer {

	public Employee getMaxSalariedEmployee(HashSet<Employee> list) {
		int maxSalary = 0;
		Employee employee = null;
		for (Employee emp : list) {
			if (maxSalary < emp.getSalary()) {
				maxSalary = emp.getSalary();
				employee = emp;
			}
		}
		return employee;
	}

	public int getNumberOfEmployeesByDesignation(HashSet<Employee> list,String designation) {
		int count=0;
		for (Employee employee : list) {
			if(employee.getDesignation().equalsIgnoreCase("'"+designation+"'"))
				count++;
		}
		return count;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*			case "'PRESIDENT'":
				president++;
				break;
			case "'MANAGER'":
				manager++;
				break;
			case "'ANALYST'":
				analyst++;
				break;
			case "'SALESMAN'":
				salesman++;
				break;
			case "'CLERK'":
				clerk++;
				break;
			}
			*/
