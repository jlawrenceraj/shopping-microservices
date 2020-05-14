package com.mphasis.fedex.catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.fedex.catalogue.model.Catalogue;
import com.mphasis.fedex.catalogue.service.CatalogueService;

@RestController
@RequestMapping("products")
public class CatalogueController {
	
	@Autowired
	CatalogueService catalogueService;
	
	@GetMapping
	public List<Catalogue> getProducts() {
		return catalogueService.getProducts();
	}

	@GetMapping("{productId}")
	public Catalogue getProductById(@PathVariable("productId") Integer productId) {
		return catalogueService.getByProductId(productId);
	}

	@PostMapping
	public Catalogue saveCatalogue(@RequestBody Catalogue catalogue) {
		return catalogueService.saveCatalogue(catalogue);
	}

	@PutMapping
	public Catalogue updateCatalogue(@RequestBody Catalogue catalogue) {
		return catalogueService.saveCatalogue(catalogue);
	}

	@DeleteMapping("{productId}")
	public void deleteProductById(@PathVariable("productId") Integer productId) {
		catalogueService.deleteProductById(productId);
	}
	
}
