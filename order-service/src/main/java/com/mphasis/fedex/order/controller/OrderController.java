package com.mphasis.fedex.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.fedex.order.model.Order;
import com.mphasis.fedex.order.model.OrderDetails;
import com.mphasis.fedex.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<OrderDetails>> getOrders() {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders());
	}

	@GetMapping("{orderId}")
	public ResponseEntity<OrderDetails> getOrderById(@PathVariable("orderId") Integer orderId) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getByOrderId(orderId));
	}

	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(order));
	}

	@PutMapping
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.saveOrder(order));
	}

	@DeleteMapping("{orderId}")
	public void deleteOrderById(@PathVariable("orderId") Integer orderId) {
		orderService.deleteProductById(orderId);
	}
	
}
