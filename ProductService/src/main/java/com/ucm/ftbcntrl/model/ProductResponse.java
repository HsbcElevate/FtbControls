package com.ucm.ftbcntrl.model;




public class ProductResponse {
	
	
	private Long productId;
	private String productName;
	private Long price;
	private Long quantity;
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public ProductResponse(String productName, Long productId, Long quantity, Long price) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductResponse [productName=" + productName + ", productId=" + productId + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	
	

}
