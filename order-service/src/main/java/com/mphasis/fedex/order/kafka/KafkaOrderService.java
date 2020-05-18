package com.mphasis.fedex.order.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.mphasis.fedex.order.model.Order;

@EnableBinding(Source.class)
public class KafkaOrderService {
	
	@Autowired
	MessageChannel output;

	public Order saveOrder(Order order) {
		output.send(MessageBuilder.withPayload(order).setHeader("type", "Order").build());
		return order;
	}
}
