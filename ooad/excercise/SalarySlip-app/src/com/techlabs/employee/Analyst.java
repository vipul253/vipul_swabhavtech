package com.techlabs.employee;

public class Analyst extends Employee {
	private double perks;

	public Analyst(int employeeID, String name, double basic_salary) {
		super(employeeID, name, basic_salary,"Analyst");
		this.perks = (basic_salary / 100) * 20;
	}

	@Override
	public double calc_CTC() {
		double CTC;
		CTC = this.perks + this.getBasicSalary();
		return CTC;
	}

	@Override
	public String toString() {
		return super.toString() + " Perks:" + this.getPerks() + " CTC:"
				+ this.calc_CTC();
	}

	public double getPerks() {
		return this.perks;
	}

	public void setPerks(double perks) {
		this.perks = perks;
	}
}
