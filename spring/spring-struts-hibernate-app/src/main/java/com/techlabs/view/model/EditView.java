package com.techlabs.view.model;

import com.techlabs.entity.Student;

public class EditView {

	private int id;
	private String firstName;
	private String lastName;
	private String address;

	public void setView(Student s) {
		this.firstName = s.getFirstName();
		this.lastName = s.getLastName();
		this.address = s.getAddress();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
