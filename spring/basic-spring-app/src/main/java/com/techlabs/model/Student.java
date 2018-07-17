package com.techlabs.model;

public class Student {

	private int rollNo;
	private String firstName;
	private String lastName;
	private String address;

	public Student() {
	}

	public Student(int rollNo, String firstName, String lastName, String address) {
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
