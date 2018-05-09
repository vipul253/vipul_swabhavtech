package com.techlabs.collegepeople;

public class Person {
	private int ID;
	private String address;
	private String DOB;
	
	public Person(int ID,String address,String DOB){
		this.ID=ID;
		this.address=address;
		this.DOB=DOB;
	}
	
	@Override
	public String toString(){
		return "ID:"+getID()+" Address:"+getAddress()+" DOB:"+getDOB();
	}
	public void setID(int ID){
		this.ID=ID;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
		
	public void setDOB(String DOB){
		this.DOB=DOB;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getDOB(){
		return this.DOB;
	}
}
