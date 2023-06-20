package com.ucm.ftbcntrl.OrderService.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ORDER_ID")
	private long orderId;

	@Column(name = "productId")
	private long productId;

	@Column(name = "QUANTITY")
	private long quantity;

	@Column(name = "ORDER_DATE")
	private Instant orderDate;

	@Column(name = "ORDER_STATUS")
	private String orderStatus;

	@Column(name = "TOTAL_AMOUNT")
	private long amount;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", orderDate="
				+ orderDate + ", orderStatus=" + orderStatus + ", amount=" + amount + "]";
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
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

	public Order(long orderId, long productId, long quantity, Instant orderDate, String orderStatus, long amount) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.amount = amount;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
