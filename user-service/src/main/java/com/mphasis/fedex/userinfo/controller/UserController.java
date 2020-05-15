package com.mphasis.fedex.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
	}

	@GetMapping("{userId}")
	public ResponseEntity<User> getUsersById(@PathVariable("userId") Integer userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersByUserId(userId));
	}

	@PostMapping
	public ResponseEntity<User> saveUsers(User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUsers(user));
	}

}
