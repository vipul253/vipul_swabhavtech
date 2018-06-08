package com.techlabs.Analyzer;

import java.util.*;

import com.techlabs.DataLoader.*;
import com.techlabs.Employee.*;

public class HeirarchyBuilder {

	// EmployeeParser parser = new EmployeeParser(new WEBLoader(
	// "https://swabhav-tech.firebaseapp.com/emp.txt"));
	
	private EmployeeParser parser = new EmployeeParser(new FileLoader(
			"Data/data.txt"));
	private HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
	private HashSet<EmployeeDTO> employeeDTO = parser.getEmpList();
	private List<Employee> employeeList = new ArrayList<Employee>();
	private Employee CEO;

	public HeirarchyBuilder() {
		makeHeirarchy();
		getCEO();
	}

	public Employee toEmployee(EmployeeDTO emp) {
		return new Employee(emp.getEmployeeID(), emp.getEmployeeName(),
				emp.getDesignation(), emp.getManagerID(), emp.getJoinDate(),
				emp.getSalary(), emp.getAge(), emp.getDepartment());
	}

	public void makeHeirarchy() {
		for (EmployeeDTO e : employeeDTO) {
			employeeList.add(toEmployee(e));
		}

		for (Employee e : employeeList) {
			if (!employeeMap.containsKey(e)) {
				employeeMap.put(e.getEmployeeID(), e);
			}
		}

		for (Employee e : employeeList) {
			if (employeeMap.containsKey(e.getManagerID())) {
				employeeMap.get(e.getManagerID()).addReportee(e);
			}
		}
	}

	public void getCEO() {
		CEO = employeeMap.get(7839);
	}

	public Employee getHead() {
		return CEO;
	}

	public Map<Integer, Employee> getMap() {
		return employeeMap;
	}
}