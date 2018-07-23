package com.sample.bank.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "RECIPIENTS")
public class Recipient {

	@Id
	private UUID id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn
	@MapsId
	private Account acc;

	@Column(columnDefinition = "BINARY(16)", nullable = false)
	private UUID recipientID;

	public UUID getRecipientID() {
		return recipientID;
	}

	public void setRecipientID(UUID recipientID) {
		this.recipientID = recipientID;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public UUID getId() {
		return id;
	}

}
