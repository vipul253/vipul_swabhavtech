package com.techlabs.employee;

public class Developer extends Employee {
	private double travel_allowance;
	private double performance_allowance;

	public Developer(int employeeID, String name, double basic_salary) {
		super(employeeID, name, basic_salary,"Developer");
		this.travel_allowance = (basic_salary / 100) * 30;
		this.performance_allowance = (basic_salary / 100) * 20;
	}

	@Override
	public double calc_CTC() {
		double CTC;
		CTC = this.performance_allowance + this.travel_allowance
				+ this.getBasicSalary();
		return CTC;
	}

	@Override
	public String toString() {
		return super.toString() + " Travel Allowance:"
				+ this.getTravelAllowance() + " Performance Allowance:"
				+ this.getPerformanceAllownace() + " CTC:" + this.calc_CTC();
	}

	public double getTravelAllowance() {
		return this.travel_allowance;
	}

	public double getPerformanceAllownace() {
		return performance_allowance;
	}

	public void setTravelAllowance(double travel_allowance) {
		this.travel_allowance = travel_allowance;
	}

	public void setPerformanceAllowance(double performance_allowance) {
		this.performance_allowance = performance_allowance;
	}
}
