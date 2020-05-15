package com.mphasis.fedex.userinfo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.fedex.userinfo.model.User;
import com.mphasis.fedex.userinfo.repository.UserRepository;

@Repository
public class UserDAO {
	
	@Autowired
	UserRepository userRepository;
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findByUserId(Integer userId) {
		return userRepository.findByUserId(userId);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
