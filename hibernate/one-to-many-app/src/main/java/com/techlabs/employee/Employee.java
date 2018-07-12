package com.techlabs.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.techlabs.department.Department;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	private int empno;
	
	@ManyToOne
	@JoinColumn
	private Department dept;
}
