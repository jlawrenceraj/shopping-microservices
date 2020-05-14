package com.mphasis.fedex.catalogue.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mphasis.fedex.catalogue.model.Catalogue;

public interface CatalogueRepository extends PagingAndSortingRepository<Catalogue, Integer>{
	
	Catalogue findByProductId(Integer productId);
	
}
