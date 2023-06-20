package com.ucm.ftbcntrl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ucm.ftbcntrl.entity.Product;
import com.ucm.ftbcntrl.model.ProductRequest;
import com.ucm.ftbcntrl.model.ProductResponse;
import com.ucm.ftbcntrl.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
		log.info("inside addProduct() of ProductController class");
		Long addProduct = productService.addProduct(productRequest);
		return new ResponseEntity<Long>(addProduct, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long productId) {
		log.info("inside getProductById() of ProductController class");
		ProductResponse productById = productService.getProductById(productId);
		return new ResponseEntity<ProductResponse>(productById, HttpStatus.OK);
	}

	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity) {
		productService.reduceQuantity(productId, quantity);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/allProduct")
	public ResponseEntity<List<Product>> allProduct() {
		List<Product> products = productService.getAllProduct();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}
