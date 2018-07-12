package com.techlabs.department;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import org.hibernate.annotations.GenericGenerator;

import com.techlabs.employee.Employee;

@Entity
public class Department {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "dno", unique = true)
	private UUID dno;
	private String name;

	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<Employee>();

	public UUID getDno() {
		return dno;
	}

	public void setDno(UUID dno) {
		this.dno = dno;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
