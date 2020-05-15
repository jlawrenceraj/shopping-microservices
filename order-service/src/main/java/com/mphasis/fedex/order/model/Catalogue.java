package com.mphasis.fedex.order.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalogue {

	private Integer productId;
	private String productName;
	private String productDesc;
	private String availability;
	private String price;
	private String manufacturer;
	private Date creationDate;
	private String createdBy;
	
}
