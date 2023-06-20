package com.ucm.ftbcntrl.OrderService.model;

import java.time.Instant;

import com.ucm.ftbcntrl.OrderService.external.response.PaymentDetails;
import com.ucm.ftbcntrl.OrderService.external.response.ProductDetails;

public class OrderResponse {

	
	private long orderId;
	private Instant orderDate;
	private String orderStatus;
	private long amount;
	private ProductDetails productDetails;
	private PaymentDetails paymentDetails;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Instant getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Instant orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public ProductDetails getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	@Override
	public String toString() {
		return "OrderResponse [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", amount=" + amount + ", productDetails=" + productDetails + ", paymentDetails=" + paymentDetails
				+ "]";
	}
	public OrderResponse(long orderId, Instant orderDate, String orderStatus, long amount,
			ProductDetails productDetails, PaymentDetails paymentDetails) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.amount = amount;
		this.productDetails = productDetails;
		this.paymentDetails = paymentDetails;
	}
	public OrderResponse() {
		super();
		
	}

	

	
	
}
