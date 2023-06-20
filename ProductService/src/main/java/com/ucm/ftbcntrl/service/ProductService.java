package com.ucm.ftbcntrl.service;

import java.util.List;

import com.ucm.ftbcntrl.entity.Product;
import com.ucm.ftbcntrl.model.ProductRequest;
import com.ucm.ftbcntrl.model.ProductResponse;

public interface ProductService {

	Long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(Long productId);

	void reduceQuantity(long productId, long quantity);

	 List<Product> getAllProduct();
	
	
	
	

}
