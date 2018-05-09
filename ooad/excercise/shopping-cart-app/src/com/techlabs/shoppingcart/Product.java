package com.techlabs.shoppingcart;

public class Product {
	private int ID;
	private String name;
	private double cost;
	private double discount;
	
	public Product(int ID, String name,double cost, double discount){
		this.ID=ID;
		this.name=name;
		this.cost=cost;
		this.discount=discount;
	}
	@Override
	public String toString(){
		return " Product ID:"+this.ID+" Product name:"+this.name+" Cost:"+this.CalculateProductCost();
	}
	
	
	public double CalculateProductCost(){
		return this.cost-(this.discount/100)*cost;
	}
	
	public int getID(){
		return this.ID;
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
