package com.mphasis.fedex.order.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.fedex.order.model.Order;
import com.mphasis.fedex.order.repository.OrderRepository;

@Repository
public class OrderDAO {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Iterable<Order> findAll() {
		
		return orderRepository.findAll();
		
	}
	
	public Order findByOrderId(Integer productId) {
		return orderRepository.findByOrderId(productId);
		
	}

	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	public void deleteOrderById(Integer orderId) {
		orderRepository.deleteById(orderId);
		
	}

}
