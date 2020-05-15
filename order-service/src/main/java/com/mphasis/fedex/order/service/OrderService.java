package com.mphasis.fedex.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.fedex.order.dao.OrderDAO;
import com.mphasis.fedex.order.model.Catalogue;
import com.mphasis.fedex.order.model.Order;
import com.mphasis.fedex.order.model.OrderDetails;
import com.mphasis.fedex.order.model.User;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;
	
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
		return orderDAO.saveOrder(order);
	}

	public void deleteProductById(Integer orderId) {
		orderDAO.deleteOrderById(orderId);
	}

	public User getUserInfo(Integer userId) {
		return userFeignClient.getuser(userId);
	}

	public Catalogue getCatalogue(Integer productId) {
		return catalogueFeignClient.getCatalogue(productId);
	}

}
