package com.techlabs.Analyzer;

import java.util.*;

import com.techlabs.DataLoader.*;
import com.techlabs.Employee.*;

public class EmployeeParser {
	HashSet<Employee> employeeList = new HashSet<Employee>();

	public EmployeeParser(Loader loader) {
		List<String> list = loader.load();

		for (String s : list) {
			String[] str = s.split(",", 8);
			int empID = Integer.parseInt(str[0]);
			int salary = Integer.parseInt(str[5]);
			int age = Integer.parseInt(str[7]);
			int mgrID=parseNull(str[3]);
			int allowance=parseNull(str[6]);
			employeeList.add(new Employee(empID, str[1], str[2], mgrID,
					str[4], salary, age, allowance));
		}
	}

	public HashSet<Employee> getEmpList() {
		return employeeList;
	}
	
	public int parseNull(String str){
		if(str.equals("NULL"))
			return 0;
		return Integer.parseInt(str);
	}
}
