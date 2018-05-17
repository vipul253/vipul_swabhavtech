package com.techlabs.srp.voilation;

public class Invoice {
	private int number;
	private String name;
	private double cost;
	private double discount;
	private final static double GST = 12.0;

	public Invoice(int number, String name, double cost, double discount) {
		this.number=number;
		this.name=name;
		this.cost=cost;
		this.discount=discount;
	}
	
	private double calcDiscount(){
		return (cost/100)*this.discount;
	}
	
	private double calcTax(){
		return (cost/100)*GST;
	}
	
	public double calcTotalCost(){
		return this.cost-this.calcDiscount()+this.calcTax();
	}
	
	public void printInvoice(){
		System.out.println(this.getNumber()+this.getName()+this.getCost()+this.getDiscount()+"% "+this.calcTax()+this.calcTotalCost());
	}
	
	public void setNumber(int number){
		this.number=number;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setCost(double cost){
		this.cost=cost;
	}
	
	public void setDiscount(double discount){
		this.discount=discount;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getCost(){
		return this.cost;
	}
	
	public double getDiscount(){
		return this.discount;
	}
}
