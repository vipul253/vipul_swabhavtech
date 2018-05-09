package com.techlabs.Employee;

public class Employee {

	private int employeeID;
	private String employeeName;
	private String designation;
	private int managerID;
	private String joinDate;
	private int salary;
	private int age;
	private int allowance;

	public Employee(int employeeID, String employeeName, String designation,
			int managerID, String joinDate, int salary, int age, int allowance) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.designation = designation;
		this.managerID = managerID;
		this.joinDate = joinDate;
		this.salary = salary;
		this.age = age;
		this.allowance = allowance;
	}

	@Override
	public int hashCode() {
		return this.employeeID;
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		if (this.employeeID == emp.getEmployeeID()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Employee ID:" + this.getEmployeeID() + " Employee Name:"
				+ this.getEmployeeName() + " Age:" + this.getAge()
				+ " Designation:" + this.getDesignation() + "\nManager ID:"
				+ this.getManagerID() + " Joining Date:" + this.getJoinDate()
				+ "Salary: " + this.getSalary() + " Allowance:"
				+ this.getAllowance() + "\n";
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	public String getEmployeeName() {
		return this.employeeName;
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

	public int getAllowance() {
		return this.allowance;
	}

}
