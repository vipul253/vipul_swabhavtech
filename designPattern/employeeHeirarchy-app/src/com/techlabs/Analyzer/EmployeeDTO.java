package com.techlabs.Analyzer;

public class EmployeeDTO {

	private int id;
	private String name;
	private String designation;
	private int managerID;
	private String joinDate;
	private int salary;
	private int age;
	private int department;

	public EmployeeDTO(int employeeID, String employeeName, String designation,
			int managerID, String joinDate, int salary, int age, int department) {
		this.id = employeeID;
		this.name = employeeName;
		this.designation = designation;
		this.managerID = managerID;
		this.joinDate = joinDate;
		this.salary = salary;
		this.age = age;
		this.department = department;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		EmployeeDTO emp = (EmployeeDTO) obj;
		if (this.id == emp.getEmployeeID()) {
			return true;
		}
		return false;
	}

	public void setEmployeeID(int employeeID) {
		this.id = employeeID;
	}

	public void setEmployeeName(String employeeName) {
		this.name = employeeName;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getEmployeeID() {
		return this.id;
	}

	public String getEmployeeName() {
		return this.name;
	}

	public String getDesignation() {
		return this.designation;
	}

	public int getManagerID() {
		return this.managerID;
	}

	public String getJoinDate() {
		return this.joinDate;
	}

	public int getSalary() {
		return this.salary;
	}

	public int getAge() {
		return this.age;
	}

	public int getDepartment() {
		return this.department;
	}
}
