package com.ucm.ftbcntrl.model;



public class ProductRequest {
	 
	
	private String productName;
	
	private Long price;
	
	private Long quantity;


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}




	@Override
	public String toString() {
		return "ProductRequest [productName=" + productName + ", price=" + price + ", quantity=" + quantity + "]";
	}


	public ProductRequest() {
		super();
	
	}
	
	

}
