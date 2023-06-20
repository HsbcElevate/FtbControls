package com.ucm.ftbcntrl.OrderService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucm.ftbcntrl.OrderService.entity.Order;
import com.ucm.ftbcntrl.OrderService.model.OrderRequest;
import com.ucm.ftbcntrl.OrderService.model.OrderResponse;
import com.ucm.ftbcntrl.OrderService.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
		long orderId = orderService.placeOrder(orderRequest);
		log.info("Order id: {}",orderId);
		return new ResponseEntity<Long>(orderId, HttpStatus.CREATED);			
	}

	@GetMapping("{orderId}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("orderId") long orderId ){
		OrderResponse orderResponse = orderService.getOrderDetails(orderId);
		return new ResponseEntity<OrderResponse>(orderResponse,HttpStatus.OK);
	}

	@GetMapping("/allOrders")
	public ResponseEntity<List<Order>> allOrders(){
		List<Order> orders=orderService.getAllOreders();
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	
}
