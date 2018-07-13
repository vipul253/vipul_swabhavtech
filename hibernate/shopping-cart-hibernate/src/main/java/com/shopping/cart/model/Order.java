package com.shopping.cart.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "id", unique = true)
	private UUID id;
	private Date date;
	
	public Order(){
		this.date = Calendar.getInstance().getTime();
	}
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<LineItem> order;
	
	@ManyToOne
	@JoinColumn
	private Customer cust;

	public Set<LineItem> getOrder() {
		return order;
	}

	public void setOrder(Set<LineItem> order) {
		this.order = order;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public UUID getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}
	
}
