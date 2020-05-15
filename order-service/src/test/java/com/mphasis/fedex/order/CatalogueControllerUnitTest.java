package com.mphasis.fedex.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mphasis.fedex.order.controller.OrderController;
import com.mphasis.fedex.order.model.Order;
import com.mphasis.fedex.order.model.OrderDetails;
import com.mphasis.fedex.order.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class CatalogueControllerUnitTest {

	@InjectMocks
	OrderController orderController;
	
	@Mock
	OrderService orderService;
	
	@Test
	public void testSaveUsers() 
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Order order = new Order(300001,200001,100001, new Date(),"Test User 1");
		when(orderService.saveOrder(any(Order.class))).thenReturn(order);
		
		Order orderToAdd = new Order(300001,200001,100001, new Date(),"Test User 1");
		ResponseEntity<Order> responseEntity = orderController.saveOrder(orderToAdd);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

	@Test
	public void testGetUsers() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		List<OrderDetails> orderDetails = new ArrayList<>();
		
		orderDetails.add(new OrderDetails("First Name 1","Last Name 1","Singapore", "123456789", "firstname@gmail.com","Product Name 1","Product Desc 1","Available","200","Manufacturer"));
		orderDetails.add(new OrderDetails("First Name 2","Last Name 2","Singapore", "123456789", "firstname@gmail.com","Product Name 2","Product Desc 2","Available","200","Manufacturer"));
		
		when(orderService.getOrders()).thenReturn(orderDetails);

		ResponseEntity<List<OrderDetails>> orders = orderController.getOrders();
		
		assertThat(orders.getBody().size()).isEqualTo(2);

		assertThat(orders.getStatusCodeValue()).isEqualTo(200);
		
		assertThat(orders.getBody().get(0).getFirstName()).isEqualTo(orderDetails.get(0).getFirstName());

		assertThat(orders.getBody().get(1).getFirstName()).isEqualTo(orderDetails.get(1).getFirstName());
		
	}

	
}