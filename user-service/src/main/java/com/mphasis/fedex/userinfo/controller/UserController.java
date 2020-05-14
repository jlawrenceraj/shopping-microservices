package com.mphasis.fedex.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.fedex.userinfo.model.User;
import com.mphasis.fedex.userinfo.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("{userId}")
	public User getUsersById(@PathVariable("userId") Integer userId) {
		return userService.getUsersByUserId(userId);
	}

	@PostMapping
	public User saveUsers(User user) {
		return userService.saveUsers(user);
	}

}
