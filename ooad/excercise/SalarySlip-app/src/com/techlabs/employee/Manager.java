package com.techlabs.employee;

public class Manager extends Employee {
	private double travel_allowance;
	private double hra;
	private double d_allowance;

	public Manager(int employeeID, String name, double basic_salary) {
		super(employeeID, name, basic_salary,"Manager");
		this.travel_allowance = (basic_salary / 100) * 30;
		this.d_allowance = (basic_salary / 100) * 40;
		this.hra = (basic_salary / 100) * 50;
	}

	@Override
	public double calc_CTC() {
		double CTC;
		CTC = this.d_allowance + this.hra + this.travel_allowance
				+ this.getBasicSalary();
		return CTC;
	}

	@Override
	public String toString() {
		return super.toString() + " Travel Allowance:"
				+ this.getTravelAllowance() + " D_Allowance:"
				+ this.getDAllowance() + " HRA:"+this.getHRA()+" CTC:" + this.calc_CTC();
	}

	public double getTravelAllowance() {
		return this.travel_allowance;
	}

	public double getDAllowance() {
		return this.d_allowance;
	}

	public double getHRA() {
		return this.hra;
	}

	public void setTravelAllowance(double travel_allowance) {
		this.travel_allowance = travel_allowance;
	}

	public void setDAllowance(double d_allowance) {
		this.d_allowance = d_allowance;
	}

	public void setHRA(double hra) {
		this.hra = hra;
	}

}
