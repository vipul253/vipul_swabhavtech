package com.techlabs.ocp.refactor;

public class FixedDeposit {
	private int account;
	private String name;
	private double principal;
	private int duration;
	private IFestival festival;

	public FixedDeposit(int account, String name, double principal,
			int duration, IFestival festival) {
		this.account = account;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festival = festival;
	}

	public double calcSimpleInterest() {
		return this.principal * (1 + (this.festival.getRate() * this.duration));
	}

	public void setAccountNumer(int account) {
		this.account = account;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public void setFestival(IFestival festival) {
		this.festival = festival;
	}

	public int getAccount() {
		return this.account;
	}

	public String getName() {
		return this.name;
	}

	public double getPrincipal() {
		return this.principal;
	}

	public int getDuration() {
		return this.duration;
	}

	public IFestival getFestival() {
		return this.festival;
	}
}
