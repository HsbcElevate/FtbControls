package com.ucm.ftbcntrl.paymentService.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSACTION_DETAILS")
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name="PAYMENT_MODE")
	private String paymentMode;
	
	@Column(name="REFERENCE_NUMBER")
	private String  referenceNumber;
	
	@Column(name="PAYMENT_DATE")
	private Instant paymentDate;
	
	@Column(name="PAYMENT_STATUS")
	private String paymentStatus;
	
	@Column(name="AMOUNT")
	private long amount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public Instant getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Instant paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "TransactionDetails [id=" + id + ", orderId=" + orderId + ", paymentMode=" + paymentMode
				+ ", referenceNumber=" + referenceNumber + ", paymentDate=" + paymentDate + ", paymentStatus="
				+ paymentStatus + ", amount=" + amount + "]";
	}

	
	public TransactionDetails(long id, long orderId, String paymentMode, String referenceNumber, Instant paymentDate,
			String paymentStatus, long amount) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.paymentMode = paymentMode;
		this.referenceNumber = referenceNumber;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.amount = amount;
	}

	public TransactionDetails() {
		super();
	
	}
	
	
	
	
	
}
