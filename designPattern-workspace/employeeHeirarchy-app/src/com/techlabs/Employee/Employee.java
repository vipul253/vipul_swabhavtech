package com.techlabs.Employee;

import java.util.*;
import com.techlabs.Analyzer.*;

public class Employee {

	private int id;
	private String name;
	private String designation;
	private int managerID;
	private String joinDate;
	private int salary;
	private int age;
	private int department;
	private List<Employee> reportees;

	public Employee(int employeeID, String employeeName, String designation,
			int managerID, String joinDate, int salary, int age, int department) {
		this.id = employeeID;
		this.name = employeeName;
		this.designation = designation;
		this.managerID = managerID;
		this.joinDate = joinDate;
		this.salary = salary;
		this.age = age;
		this.department = department;
		this.reportees = new ArrayList<Employee>();
	}
	
	public void addReportee(Employee emp){
		this.reportees.add(emp);
	}
	
	public void removeEmployee(EmployeeDTO emp){
		this.reportees.remove(emp);
	}
	
	public List<Employee> getReportees(){
		return this.reportees;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		if (this.id == emp.getEmployeeID()) {
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
				+ this.getDepartment() + "\n";
	}
	
	public void getDetails(){
		System.out.println(this.getDesignation()+"->"+this.getEmployeeName());
		for(Employee e : this.getReportees()){
			e.getDetails();
		}
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
