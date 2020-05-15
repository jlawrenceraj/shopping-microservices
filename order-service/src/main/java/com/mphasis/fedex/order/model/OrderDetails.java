package com.mphasis.fedex.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {

	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	private String productName;
	private String productDesc;
	private String availability;
	private String price;
	private String manufacturer;
	
	
}
