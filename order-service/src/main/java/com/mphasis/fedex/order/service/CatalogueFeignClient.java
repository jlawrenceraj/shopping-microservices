package com.mphasis.fedex.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mphasis.fedex.order.model.Catalogue;

@FeignClient(name = "shopping-catalogue-service")
public interface CatalogueFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/catalogue/products/{productId}", produces = "application/json")
	Catalogue getCatalogue(@PathVariable Integer productId);
}
