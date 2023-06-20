package com.ucm.ftbcntrl.paymentService.service;

import com.ucm.ftbcntrl.paymentService.model.PaymentRequest;
import com.ucm.ftbcntrl.paymentService.model.PaymentResponse;

public interface PaymentService {

	long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPaymentDetailsByOrderId(String orderId);

}
