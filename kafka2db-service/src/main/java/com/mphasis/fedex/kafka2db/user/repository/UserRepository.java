package com.mphasis.fedex.kafka2db.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mphasis.fedex.kafka2db.user.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{
	
	User findByUserId(Integer userId);
	
}
