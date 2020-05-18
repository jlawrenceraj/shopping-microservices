package com.mphasis.fedex.kafka2db.catalogue.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.fedex.kafka2db.catalogue.model.Catalogue;
import com.mphasis.fedex.kafka2db.catalogue.repository.CatalogueRepository;

@Repository
public class CatalogueDAO {

	@Autowired
	CatalogueRepository catalogueRepository;

	public Catalogue saveCatalogue(Catalogue catalogue) {
		return catalogueRepository.save(catalogue);
	}

}
