package com.mphasis.fedex.order.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mphasis.fedex.order.model.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer>{
	
	Order findByOrderId(Integer orderId);
	
	
}
