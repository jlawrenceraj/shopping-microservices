package com.mphasis.fedex.kafka2db.order.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.fedex.kafka2db.order.model.Order;
import com.mphasis.fedex.kafka2db.order.repository.OrderRepository;

@Repository
public class OrderDAO {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

}
