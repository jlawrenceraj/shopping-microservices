package com.mphasis.fedex.shopping.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mphasis.fedex.catalogue.controller.CatalogueController;
import com.mphasis.fedex.catalogue.model.Catalogue;
import com.mphasis.fedex.catalogue.service.CatalogueService;

@ExtendWith(MockitoExtension.class)
public class CatalogueControllerUnitTest {

	@InjectMocks
	CatalogueController catalogueController;
	
	@Mock
	CatalogueService catalogueService;
	
	@Test
	public void testSaveUsers() 
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Catalogue catalogue = new Catalogue(200002,"Sample Product 2","Sample Product Desc 2", "Available", "200","Manufacturer",new Date(),"Test User 2");
		when(catalogueService.saveCatalogue(any(Catalogue.class))).thenReturn(catalogue);
		
		Catalogue catalogueToAdd = new Catalogue(200001,"Sample Product 1","Sample Product Desc 2", "Available", "300","Manufacturer",new Date(),"Test User 2");
		ResponseEntity<Catalogue> responseEntity = catalogueController.saveCatalogue(catalogueToAdd);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

	@Test
	public void testGetUsers() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		List<Catalogue> users = new ArrayList<>();
		
		users.add(new Catalogue(200001,"Sample Product 1","Sample Product Desc 2", "Available", "300","Manufacturer",new Date(),"Test User 2"));
		users.add(new Catalogue(200002,"Sample Product 2","Sample Product Desc 2", "Available", "200","Manufacturer",new Date(),"Test User 2"));
		
		when(catalogueService.getProducts()).thenReturn(users);

		ResponseEntity<List<Catalogue>> catalogues = catalogueController.getProducts();
		
		assertThat(catalogues.getBody().size()).isEqualTo(2);

		assertThat(catalogues.getStatusCodeValue()).isEqualTo(200);
		
		assertThat(catalogues.getBody().get(0).getProductId()).isEqualTo(users.get(0).getProductId());

		assertThat(catalogues.getBody().get(1).getProductId()).isEqualTo(users.get(1).getProductId());
		
	}

	
}