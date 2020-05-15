package com.mphasis.fedex.userinfo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mphasis.fedex.userinfo.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{
	
	User findByUserId(Integer userId);
	
}
