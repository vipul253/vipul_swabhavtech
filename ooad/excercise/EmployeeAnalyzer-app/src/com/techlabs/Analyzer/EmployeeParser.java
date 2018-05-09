package com.techlabs.Analyzer;

import java.util.*;

import com.techlabs.DataLoader.*;
import com.techlabs.Employee.*;

public class EmployeeParser {
	HashSet<Employee> EmployeeList = new HashSet<Employee>();

	public EmployeeParser(Loader loader) {
		ArrayList<String> list = loader.load();

		for (String s : list) {
			try {
				String[] str = s.split(",", 8);
				int empID = Integer.parseInt(str[0]);
				int mgrID, allowance;
				try {
					mgrID = Integer.parseInt(str[3]);
					allowance = Integer.parseInt(str[6]);
				} catch (NumberFormatException e) {
					mgrID = 0;
					allowance = 0;
				}
				int salary = Integer.parseInt(str[5]);
				int age = Integer.parseInt(str[7]);
				EmployeeList.add(new Employee(empID, str[1], str[2], mgrID,
						str[4], salary, age, allowance));
			} catch (NullPointerException e) {
				break;
			}
		}
	}

	public HashSet<Employee> getEmpList() {
		return EmployeeList;
	}
}
