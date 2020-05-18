package com.mphasis.fedex.kafka2db.order.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mphasis.fedex.kafka2db.order.model.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer>{
	
	Order findByOrderId(Integer orderId);
	
}
