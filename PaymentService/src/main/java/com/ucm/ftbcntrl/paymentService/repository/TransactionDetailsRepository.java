package com.ucm.ftbcntrl.paymentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucm.ftbcntrl.paymentService.entity.TransactionDetails;



@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

	
	TransactionDetails findByOrderId(long orderId);
	
}
