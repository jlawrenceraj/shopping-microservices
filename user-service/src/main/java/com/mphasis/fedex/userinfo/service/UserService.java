package com.mphasis.fedex.userinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.fedex.userinfo.dao.UserDAO;
import com.mphasis.fedex.userinfo.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	public List<User> getUsers() {
		
		List<User> users = new ArrayList<>();
		userDAO.findAll().forEach(user -> users.add(user));;
		return users;
	}
	
	public User getUsersByUserId(Integer userId) {

		return userDAO.findByUserId(userId);
	}

	public User saveUsers(User user) {

		return userDAO.saveUser(user);
	}
}
