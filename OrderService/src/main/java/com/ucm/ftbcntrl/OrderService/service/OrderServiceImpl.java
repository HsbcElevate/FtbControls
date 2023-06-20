package com.ucm.ftbcntrl.OrderService.service;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ucm.ftbcntrl.OrderService.entity.Order;
import com.ucm.ftbcntrl.OrderService.exceptions.CustomeException;
import com.ucm.ftbcntrl.OrderService.external.client.PaymentService;
import com.ucm.ftbcntrl.OrderService.external.client.ProductService;
import com.ucm.ftbcntrl.OrderService.external.request.PaymentRequest;
import com.ucm.ftbcntrl.OrderService.external.response.PaymentDetails;
import com.ucm.ftbcntrl.OrderService.external.response.ProductDetails;
import com.ucm.ftbcntrl.OrderService.model.OrderRequest;
import com.ucm.ftbcntrl.OrderService.model.OrderResponse;
import com.ucm.ftbcntrl.OrderService.repository.OrderRepository;
import com.ucm.ftbcntrl.model.ProductResponse;
import com.ucm.ftbcntrl.paymentService.model.PaymentResponse;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public long placeOrder(OrderRequest orderRequest) {
		// Order Entity -> Save the data with Status Order Created
		// Product Service - Block Products (Reduce the Quantity)
		// Payment Service -> Payments -> Success-> COMPLETE, Else
		// CANCELLED

		log.info("placing Order Request: {}", orderRequest);
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		Order order = new Order();
		order.setProductId(orderRequest.getProductId());
		order.setQuantity(orderRequest.getQuantity());
		order.setOrderDate(Instant.now());
		order.setOrderStatus("CREATED");
		order.setAmount(orderRequest.getTotalAmount());
		order = orderRepository.save(order);
		log.info("Calling payment Service to Complete the payment");
		PaymentRequest PaymentRequest = new PaymentRequest();
		PaymentRequest.setOrderId(order.getOrderId());
		PaymentRequest.setAmount(orderRequest.getTotalAmount());
		PaymentRequest.setPaymentMode(orderRequest.getPaymentMode());
		String orderStatus = null;
		try {
			paymentService.doPayment(PaymentRequest);
			log.info("Payment done Successfully . Changing the Order Status to PLACED");
			orderStatus = "PLACED";
		} catch (Exception e) {
			log.error("Error Occurred in Payment ,Changing Order Status to PAYMENT_FAILED");
			orderStatus = "PAYMENT_FAILED";
		}
		order.setOrderStatus(orderStatus);
		orderRepository.save(order);
		log.info("Order Ordered Successfully with Order Id: {}", order.getOrderId());
		return order.getOrderId();
	}

	@Override
	public OrderResponse getOrderDetails(long orderId) {
		log.info("Get order details for Order Id: {}", orderId);
		Order orderObject = orderRepository.findById(orderId).orElseThrow(
				() -> new CustomeException("Order not found for the Order Id: " + orderId, "NOT_FOUND", 404));

	log.info("Invoking Product Service to fetch the Product for id :{}",orderObject.getProductId());
	ProductResponse productResponse = restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+orderObject.getProductId(), ProductResponse.class);
	
	ProductDetails productDetails=new ProductDetails();
	productDetails.setProductId(productResponse.getProductId());
	productDetails.setProductName(productResponse.getProductName());
	productDetails.setPrice(productResponse.getPrice());
	productDetails.setQuantity(productResponse.getQuantity());
	
	log.info("Getting Payment Information from the Payment Service");
	
	PaymentResponse paymentResponse = restTemplate.getForObject("http://PAYMENT-SERVICE/payment/order/"+orderObject.getOrderId(), PaymentResponse.class);
	System.out.println("paymentResponse.getPaymentMode()================"+paymentResponse.getPaymentMode());
	PaymentDetails paymentDetails = new  PaymentDetails();
	paymentDetails.setPaymentdId(paymentResponse.getPaymentdId());
	paymentDetails.setOrderId(paymentResponse.getOrderId());
	//paymentDetails.setPaymentMode(paymentResponse.getPaymentMode());
	paymentDetails.setPaymentDate(paymentResponse.getPaymentDate());
	paymentDetails.setStatus(paymentResponse.getStatus());
	paymentDetails.setAmount(paymentResponse.getAmount());
	
	OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderObject.getOrderId());
		orderResponse.setOrderDate(orderObject.getOrderDate());
		orderResponse.setOrderStatus(orderObject.getOrderStatus());
		orderResponse.setAmount(orderObject.getAmount());
		orderResponse.setProductDetails(productDetails);
		orderResponse.setPaymentDetails(paymentDetails);
		return orderResponse;
	}

	@Override
	public List<Order> getAllOreders() {
		log.info("fetching All Orders ");
		List<Order> orders = orderRepository.findAll();
		return orders;
	}

}
