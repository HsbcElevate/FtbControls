package com.ucm.ftbcntrl.OrderService.external.response;




public class ProductDetails {
	
	
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

	@Override
	public String toString() {
		return "ProductDetails [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

	public ProductDetails(Long productId, String productName, Long price, Long quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public ProductDetails() {
		super();
	
	}

	
	

}
