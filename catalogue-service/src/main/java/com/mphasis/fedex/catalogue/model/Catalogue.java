package com.mphasis.fedex.catalogue.model;

import java.util.Date;

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
	private Integer productId;
	private String productName;
	private String productDesc;
	private String availability;
	private String price;
	private String manufacturer;
	private Date creationDate;
	private String createdBy;
	
}
