package com.mphasis.fedex.kafka2db.catalogue.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "catalogue")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalogue {

	@Id
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_desc")
	private String productDesc;
	@Column(name = "availability")
	private String availability;
	@Column(name = "price")
	private String price;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "creation_date")
	private Date creationDate;
	@Column(name = "created_by")
	private String createdBy;
	
}
