package com.mphasis.fedex.catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Catalogue>> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(catalogueService.getProducts());
	}

	@GetMapping("{productId}")
	public ResponseEntity<Catalogue> getProductById(@PathVariable("productId") Integer productId) {
		return ResponseEntity.status(HttpStatus.OK).body(catalogueService.getByProductId(productId));
	}

	@PostMapping
	public ResponseEntity<Catalogue> saveCatalogue(@RequestBody Catalogue catalogue) {
		return ResponseEntity.status(HttpStatus.CREATED).body(catalogueService.saveCatalogue(catalogue));
	}

	@PutMapping
	public ResponseEntity<Catalogue> updateCatalogue(@RequestBody Catalogue catalogue) {
		return ResponseEntity.status(HttpStatus.OK).body(catalogueService.saveCatalogue(catalogue));
	}

	@DeleteMapping("{productId}")
	public void deleteProductById(@PathVariable("productId") Integer productId) {
		catalogueService.deleteProductById(productId);
	}
	
}
