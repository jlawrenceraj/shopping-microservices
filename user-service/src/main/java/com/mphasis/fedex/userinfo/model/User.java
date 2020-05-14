package com.mphasis.fedex.userinfo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
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
