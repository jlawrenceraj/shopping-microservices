package com.mphasis.fedex.shopping.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mphasis.fedex.userinfo.controller.UserController;
import com.mphasis.fedex.userinfo.model.User;
import com.mphasis.fedex.userinfo.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerUnitTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Test
	public void testSaveUsers() 
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		User user = new User(10002,"FirstName2","LastName2","Testing Address","1234567890","firstname@gmail.com","UserName2",new Date(),"Testing User 2");
		when(userService.saveUsers(any(User.class))).thenReturn(user);
		
		User userToAdd = new User(10001,"FirstName1","LastName1","Testing Address","1234567890","firstname@gmail.com","UserName1",new Date(),"Testing User 1");
		ResponseEntity<User> responseEntity = userController.saveUsers(userToAdd);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

	@Test
	public void testGetUsers() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		List<User> users = new ArrayList<>();
		
		users.add(new User(10001,"FirstName1","LastName1","Testing Address","1234567890","firstname@gmail.com","UserName1",new Date(),"Testing User 1"));
		users.add(new User(10002,"FirstName2","LastName2","Testing Address","1234567890","firstname@gmail.com","UserName2",new Date(),"Testing User 2"));
		
		when(userService.getUsers()).thenReturn(users);

		ResponseEntity<List<User>> userList = userController.getUsers();
		
		assertThat(userList.getBody().size()).isEqualTo(2);

		assertThat(userList.getStatusCodeValue()).isEqualTo(200);
		
		assertThat(userList.getBody().get(0).getFirstName()).isEqualTo(users.get(0).getFirstName());

		assertThat(userList.getBody().get(1).getFirstName()).isEqualTo(users.get(1).getFirstName());
		
	}

	
}