package com.techlabs.department;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	private int dno;
}
