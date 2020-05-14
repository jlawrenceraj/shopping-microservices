package com.mphasis.fedex.catalogue.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.fedex.catalogue.model.Catalogue;
import com.mphasis.fedex.catalogue.repository.CatalogueRepository;

@Repository
public class CatalogueDAO {
	
	@Autowired
	CatalogueRepository catalogueRepository;
	
	public Iterable<Catalogue> findAll() {
		
		return catalogueRepository.findAll();
		
	}
	
	public Catalogue findByProductId(Integer productId) {
		return catalogueRepository.findByProductId(productId);
		
	}

	public Catalogue saveCatalogue(Catalogue catalogue) {
		return catalogueRepository.save(catalogue);
	}

	public void deleteProductById(Integer productId) {
		catalogueRepository.deleteById(productId);
		
	}

}
