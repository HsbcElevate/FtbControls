package com.ucm.ftbcntrl.entity;

public  class ProductBuilder {

	private Long productId;

	private String productName;

	private Long price;

	private String quantity;
	

	public ProductBuilder(Long productId, String productName, Long price, String quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public Product build() {
		Product product=new Product();
		return product;
	}
	

}
