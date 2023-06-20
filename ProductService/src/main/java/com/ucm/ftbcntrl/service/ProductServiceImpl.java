package com.ucm.ftbcntrl.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucm.ftbcntrl.entity.Product;
import com.ucm.ftbcntrl.exceptions.ProductServiceCustomException;
import com.ucm.ftbcntrl.model.ProductRequest;
import com.ucm.ftbcntrl.model.ProductResponse;
import com.ucm.ftbcntrl.repository.ProductRepository;

@Service("ProductService")

public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long addProduct(ProductRequest productRequest) {
		log.info("adding Product");
		Product product = new Product();
		product.setProductName(productRequest.getProductName());
		product.setPrice(productRequest.getPrice());
		product.setQuantity(productRequest.getQuantity());
		log.info("Product Created ");
		productRepository.save(product);
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(Long productId) {
		log.info("Get the product for :" + productId);
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceCustomException("Product with given id is not found :" + productId,
						"PRODUCT_NOT_FOUND"));
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);
		return productResponse;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		log.info("Reduce Quantity {} for Id :{}", quantity, productId);
		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with givern Id not found ", "PRODUCT_NOT_FOUND"));
		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException("Product does not have Sufficient Quantity",
					"INSUFFICIENT_QUANTITY");
		}
		product.setQuantity(product.getQuantity() - quantity);
		productRepository.save(product);
		log.info("Product Quantity Updated Successfully");

	}

	@Override
	public List<Product> getAllProduct() {
		log.info("fetching all Product");
		List<Product> findAll = productRepository.findAll();
		return findAll;
	}

}
