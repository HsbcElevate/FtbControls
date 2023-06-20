package com.ucm.ftbcntrl.paymentService.controller;

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

import com.ucm.ftbcntrl.paymentService.model.PaymentRequest;
import com.ucm.ftbcntrl.paymentService.model.PaymentResponse;
import com.ucm.ftbcntrl.paymentService.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	private static final Logger log=LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
		long doPayment = paymentService.doPayment(paymentRequest);
		return new ResponseEntity<Long>(doPayment,HttpStatus.CREATED);	
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable(value = "orderId") String orderId){
		PaymentResponse paymentDetailsByOrderId = paymentService.getPaymentDetailsByOrderId(orderId);
		return new ResponseEntity<PaymentResponse>(paymentDetailsByOrderId, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
