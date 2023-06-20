package com.ucm.ftbcntrl.OrderService.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucm.ftbcntrl.OrderService.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Serializable> {

	
	
	
	
}
