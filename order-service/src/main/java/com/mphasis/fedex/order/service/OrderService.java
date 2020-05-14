package com.mphasis.fedex.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.fedex.order.dao.OrderDAO;
import com.mphasis.fedex.order.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	public List<Order> getOrders() {
		
		List<Order> orders = new ArrayList<>();
		orderDAO.findAll().forEach(orders::add);
		return orders;
	}
	
	public Order getByOrderId(Integer orderId) {

		return orderDAO.findByOrderId(orderId);
	}

	public Order saveCatalogue(Order order) {

		return orderDAO.saveOrder(order);
	}

	public void deleteProductById(Integer orderId) {

		orderDAO.deleteOrderById(orderId);
	}

}
