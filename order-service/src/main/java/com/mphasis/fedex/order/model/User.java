package com.mphasis.fedex.order.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	private String userName;
	private Date creationDate;
	private String createdBy;
	
}
