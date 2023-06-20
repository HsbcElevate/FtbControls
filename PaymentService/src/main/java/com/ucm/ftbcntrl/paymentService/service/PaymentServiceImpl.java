package com.ucm.ftbcntrl.paymentService.service;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucm.ftbcntrl.paymentService.entity.TransactionDetails;
import com.ucm.ftbcntrl.paymentService.model.PaymentMode;
import com.ucm.ftbcntrl.paymentService.model.PaymentRequest;
import com.ucm.ftbcntrl.paymentService.model.PaymentResponse;
import com.ucm.ftbcntrl.paymentService.repository.TransactionDetailsRepository;

@Service("PaymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	private TransactionDetailsRepository transactionDetailsRepository;
	
	
	@Override
	public long doPayment(PaymentRequest paymentRequest) {
		log.info("Recording payment details: {}", paymentRequest);
		TransactionDetails transactionDetails=new TransactionDetails();
		transactionDetails.setOrderId(paymentRequest.getOrderId());
		transactionDetails.setPaymentMode(paymentRequest.getPaymentMode().name());
		transactionDetails.setReferenceNumber(paymentRequest.getReferenceNumber());
		transactionDetails.setPaymentDate(Instant.now());
		transactionDetails.setPaymentStatus("SUCCESS");
		transactionDetails.setAmount(paymentRequest.getAmount());
		
		transactionDetailsRepository.save(transactionDetails).getId();
		log.info("Transaction Completed with Id :{}",transactionDetails.getId());
	
		return transactionDetails.getId();
	}


	@Override
	public PaymentResponse getPaymentDetailsByOrderId(String orderId) {
	
		log.info("Getting Payment Details For the Order Id: {}",orderId);
		TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(Long.valueOf(orderId));
	
		//creating object for PaymentResponse to set the value 
		PaymentResponse paymentResponse=new PaymentResponse();
		paymentResponse.setPaymentdId(transactionDetails.getId());
		paymentResponse.setOrderId(transactionDetails.getOrderId());
		paymentResponse.setPaymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()));
		paymentResponse.setPaymentDate(transactionDetails.getPaymentDate());
		paymentResponse.setStatus(transactionDetails.getPaymentStatus());
		paymentResponse.setAmount(transactionDetails.getAmount());
		
		return paymentResponse;
	}

}
