package com.mphasis.fedex.order.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	private Integer orderId;
	private Integer productId;
	private Integer userId;
	private Date creationDate;
	private String createdBy;
	
}
