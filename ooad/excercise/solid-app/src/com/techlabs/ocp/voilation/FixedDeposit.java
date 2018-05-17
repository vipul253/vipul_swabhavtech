package com.techlabs.ocp.voilation;

public class FixedDeposit {
	private int account;
	private String name;
	private double principal;
	private int duration;
	private FestivalType festival;

	public FixedDeposit(int account, String name, double principal,
			int duration, FestivalType festival) {
		this.account = account;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festival = festival;
	}

	public double calcSimpleInterest() {
		if (this.festival.equals(FestivalType.NEWYEAR)) {
			return this.principal * (1 + (9 * this.duration));
		} else if (this.festival.equals(FestivalType.HOLI)) {
			return this.principal * (1 + (8 * this.duration));

		} else {
			return this.principal * (1 + (6.5 * this.duration));
		}
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

	public void setFestival(FestivalType festival) {
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

	public FestivalType getFestival() {
		return this.festival;
	}
}
