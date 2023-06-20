package com.ucm.ftbcntrl.OrderService.external.response;

import java.time.Instant;

import com.ucm.ftbcntrl.OrderService.model.PaymentMode;

public class PaymentDetails {

	private long paymentdId;
	private long orderId;
	private PaymentMode paymentMode;
	private Instant paymentDate;
	private String status;
	private long amount;
	
	
	
	public long getPaymentdId() {
		return paymentdId;
	}
	public void setPaymentdId(long paymentdId) {
		this.paymentdId = paymentdId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Instant getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Instant paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PaymentDetails [paymentdId=" + paymentdId + ", orderId=" + orderId + ", paymentMode=" + paymentMode
				+ ", paymentDate=" + paymentDate + ", status=" + status + ", amount=" + amount + "]";
	}
	public PaymentDetails(long paymentdId, long orderId, PaymentMode paymentMode, Instant paymentDate, String status,
			long amount) {
		super();
		this.paymentdId = paymentdId;
		this.orderId = orderId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.status = status;
		this.amount = amount;
	}
	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}







}
