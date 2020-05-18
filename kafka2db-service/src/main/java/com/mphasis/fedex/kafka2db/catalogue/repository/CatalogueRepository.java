package com.mphasis.fedex.kafka2db.catalogue.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mphasis.fedex.kafka2db.catalogue.model.Catalogue;

public interface CatalogueRepository extends PagingAndSortingRepository<Catalogue, Integer>{
	
	Catalogue findByProductId(Integer productId);
	
}
