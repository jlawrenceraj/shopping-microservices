package com.mphasis.fedex.order.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.fedex.order.dao.OrderDAO;
import com.mphasis.fedex.order.kafka.KafkaOrderService;
import com.mphasis.fedex.order.model.Catalogue;
import com.mphasis.fedex.order.model.Order;
import com.mphasis.fedex.order.model.OrderDetails;
import com.mphasis.fedex.order.model.User;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	KafkaOrderService kafkaOrderService;
	
	@Autowired
	UserFeignClient userFeignClient;

	@Autowired
	CatalogueFeignClient catalogueFeignClient;

	public List<OrderDetails> getOrders() {

		List<Order> orders = new ArrayList<>();
		List<OrderDetails> orderDetails = new ArrayList<>();
		orderDAO.findAll().forEach(orders::add);
		orders.forEach(order -> {
			orderDetails.add(getByOrderId(order.getOrderId()));
		});
		return orderDetails;
	}

	public OrderDetails getByOrderId(Integer orderId) {
		OrderDetails orderDetails = new OrderDetails();
		Order order = orderDAO.findByOrderId(orderId);

		BeanUtils.copyProperties(getUserInfo(order.getUserId()), orderDetails); // Getting User information
		BeanUtils.copyProperties(getCatalogue(order.getProductId()), orderDetails); // Getting Production information
		return orderDetails;
	}

	public Order saveOrder(Order order) {
		kafkaOrderService.saveOrder(order);
		return order;
	}

	public void deleteProductById(Integer orderId) {
		orderDAO.deleteOrderById(orderId);
	}

    @CircuitBreaker(name = "getUserInfo", fallbackMethod = "fallbackForUser")
	public User getUserInfo(Integer userId) {
		return userFeignClient.getuser(userId);
	}
    
    public User fallbackForUser(Integer userId, Throwable t) {
        log.error("Inside circuit breaker fallbackForUser, cause - {}", t.toString());
        return new User(userId, "Default first name", "Default last name", "Office Address", "+00 000 000 0000", StringUtils.EMPTY, "Default User name", new Date(), "Admin");
    }

    @CircuitBreaker(name = "getCatalogue", fallbackMethod = "fallbackForCatalogue")
	public Catalogue getCatalogue(Integer productId) {
		return catalogueFeignClient.getCatalogue(productId);
	}
	
    public Order fallbackForCatalogue(Integer orderId, Throwable t) {
        log.error("Inside circuit breaker fallbackForUser, cause - {}", t.toString());
        return new Order(orderId, 200001, 100001, new Date(), "Admin");
    }
	

}
