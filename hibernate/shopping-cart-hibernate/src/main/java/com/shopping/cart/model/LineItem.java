package com.shopping.cart.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "LINEITEMS")
public class LineItem {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "id", unique = true)
	private UUID id;
	private int quantity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Product product;

	@ManyToOne
	@JoinColumn
	private Order order;
	
	@Override
	public String toString() {
		return "\n" + this.product.toString() + " Quantity:" + this.quantity
				+ " Total Cost:" + this.CalculateTotalCost();
	}

	public double CalculateTotalCost() {
		return this.quantity * this.product.CalculateProductCost();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UUID getId() {
		return id;
	}
}
