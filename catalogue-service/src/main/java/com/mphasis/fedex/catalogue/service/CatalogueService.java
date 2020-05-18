package com.mphasis.fedex.catalogue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.fedex.catalogue.dao.CatalogueDAO;
import com.mphasis.fedex.catalogue.kafka.KafkaCatalogueService;
import com.mphasis.fedex.catalogue.model.Catalogue;

@Service
public class CatalogueService {

	@Autowired
	CatalogueDAO catalogueDAO;
	
	@Autowired
	KafkaCatalogueService catalogueService;
	
	public List<Catalogue> getProducts() {
		
		List<Catalogue> catalogues = new ArrayList<>();
		catalogueDAO.findAll().forEach(catalogues::add);
		return catalogues;
	}
	
	public Catalogue getByProductId(Integer productId) {

		return catalogueDAO.findByProductId(productId);
	}

	public Catalogue saveCatalogue(Catalogue catalogue) {
		catalogueService.saveCatalogue(catalogue);
		return catalogue;
	}

	public void deleteProductById(Integer productId) {

		catalogueDAO.deleteProductById(productId);
	}

}
