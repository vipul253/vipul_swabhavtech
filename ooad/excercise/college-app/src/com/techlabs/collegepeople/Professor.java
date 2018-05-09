package com.techlabs.collegepeople;

public class Professor extends Person implements SalariedEmployee {
	private double basic_salary;
	private double medical_allowance;
	private double travel_allowance;

	public Professor(int ID, String address, String DOB, double basic_salary) {
		super(ID, address, DOB);
		this.basic_salary = basic_salary;
		this.medical_allowance = (basic_salary / 100) * 30;
		this.travel_allowance = (basic_salary / 100) * 15;
	}

	
	
	@Override
	public String toString(){
		return super.toString()+" Salary:"+CalcSalary();
	}
	
	public double CalcSalary() {
		return getBasicSalary() + getTravelAllowance() + getMedicalAllowance();
	}

	public void setBasicSalary(double basic_salary) {
		this.basic_salary = basic_salary;
	}

	public double getBasicSalary() {
		return this.basic_salary;
	}

	public double getTravelAllowance() {
		return this.travel_allowance;
	}

	public double getMedicalAllowance() {
		return this.medical_allowance;
	}

}
