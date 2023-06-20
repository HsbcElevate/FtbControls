package com.ucm.ftbcntrl.OrderService.service;

import java.util.List;

import com.ucm.ftbcntrl.OrderService.entity.Order;
import com.ucm.ftbcntrl.OrderService.model.OrderRequest;
import com.ucm.ftbcntrl.OrderService.model.OrderResponse;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

	OrderResponse getOrderDetails(long orderId);

	List<Order> getAllOreders();


}
