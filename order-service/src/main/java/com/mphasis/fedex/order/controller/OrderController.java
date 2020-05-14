package com.mphasis.fedex.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.fedex.order.model.Order;
import com.mphasis.fedex.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}

	@GetMapping("{orderId}")
	public Order getOrderById(@PathVariable("orderId") Integer orderId) {
		return orderService.getByOrderId(orderId);
	}

	@PostMapping
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveCatalogue(order);
	}

	@PutMapping
	public Order updateOrder(@RequestBody Order order) {
		return orderService.saveCatalogue(order);
	}

	@DeleteMapping("{orderId}")
	public void deleteOrderById(@PathVariable("orderId") Integer orderId) {
		orderService.deleteProductById(orderId);
	}
	
}
