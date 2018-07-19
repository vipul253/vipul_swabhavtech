package com.sample.bank.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "id", unique = true)
	private UUID id;
	private double balance;
	
	
	@OneToMany(mappedBy = "acc", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Transaction> txn = new HashSet<>();

	public UUID getId() {
		return id;
	}

	public Set<Transaction> getTxn() {
		return txn;
	}

	public void setTxn(Set<Transaction> txn) {
		this.txn = txn;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
