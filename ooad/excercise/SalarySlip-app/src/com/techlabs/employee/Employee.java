package com.techlabs.employee;

public abstract class Employee {
	private int employeeID;
	private String name;
	private double basic_salary;
	private String role;

	public Employee(int employeeID, String name, double basic_salary,
			String role) {
		this.role = role;
		this.employeeID = employeeID;
		this.name = name;
		this.basic_salary = basic_salary;
	}

	public abstract double calc_CTC();

	@Override
	public String toString() {
		return "ID:" + this.getEmployeeID() + " Name:" + this.getName()
				+ " Role:" + this.getRole() + " BasicSalary:"
				+ this.getBasicSalary();
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	public String getName() {
		return this.name;
	}

	public double getBasicSalary() {
		return this.basic_salary;
	}

	public String getRole() {
		return this.role;
	}

	public void setID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBasicSalary(double basic_salary) {
		this.basic_salary = basic_salary;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
