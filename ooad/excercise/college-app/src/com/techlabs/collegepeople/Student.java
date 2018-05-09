package com.techlabs.collegepeople;

public class Student extends Person {
	private Branch branch;
	
	public Student(int ID,String address,String DOB,Branch branch){
		super(ID,address,DOB);
		this.branch=branch;
	}
	
	@Override
	public String toString(){
		return super.toString()+" Branch:"+getBranch();
	}
	public void setBranch(Branch branch){
		this.branch=branch;
	}
	
	public Branch getBranch(){
		return this.branch;
	}
}
