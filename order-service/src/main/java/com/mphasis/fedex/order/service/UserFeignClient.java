package com.mphasis.fedex.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mphasis.fedex.order.model.User;

@FeignClient(name = "shopping-user-service")
public interface UserFeignClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/userinfo/users/{userId}", produces = "application/json")
	User getuser(@PathVariable("userId") Integer userId);

}
