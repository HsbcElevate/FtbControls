package com.ucm.ftbcntrl.OrderService.model;



public class OrderRequest {
	
	private long productId;
	
	private long totalAmount;
	
	private long quantity;
	
	private PaymentMode paymentMode;

	
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "OrderRequest [productId=" + productId + ", totalAmount=" + totalAmount + ", quantity=" + quantity
				+ ", paymentMode=" + paymentMode + "]";
	}

	public OrderRequest(long productId, long totalAmount, long quantity, PaymentMode paymentMode) {
		super();
		this.productId = productId;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
		this.paymentMode = paymentMode;
	}

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
