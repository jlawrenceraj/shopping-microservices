package com.mphasis.fedex.userinfo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.mphasis.fedex.userinfo.model.User;

@EnableBinding(Source.class)
public class KafkaUserService {
	
	@Autowired
	MessageChannel output;

	public User saveUser(User user) {
		output.send(MessageBuilder.withPayload(user).setHeader("type", "User").build());
		return user;
	}
}
