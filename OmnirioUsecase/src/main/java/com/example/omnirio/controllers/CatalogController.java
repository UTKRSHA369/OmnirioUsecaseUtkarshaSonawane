package com.example.omnirio.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.omnirio.exceptions.ControllerException;
import com.example.omnirio.models.Attribute;
import com.example.omnirio.models.Category;
import com.example.omnirio.models.Product;
import com.example.omnirio.services.CatalogService;

@RestController
@RequestMapping("/api")
public class CatalogController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);
	
	@Autowired
	CatalogService catalogService;
	
	@PostMapping("/createAttribute")
	public ResponseEntity<Object> createAttribute(@RequestBody Attribute attribute) throws ControllerException {
		try {
			return ResponseEntity.status(201).body(catalogService.createAttribute(attribute));
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ControllerException(exception.getMessage(), exception);
		}
	}
	
	@PostMapping("/createCategory")
	public ResponseEntity<Object> createCategory(@RequestBody Category category) throws ControllerException {
		try {
			return ResponseEntity.status(201).body(catalogService.createCategory(category));
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ControllerException(exception.getMessage(), exception);
		}
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) throws ControllerException {
		try {
			return ResponseEntity.status(201).body(catalogService.createProduct(product));
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ControllerException(exception.getMessage(), exception);
		}
	}
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable Long id) throws ControllerException {
		try {
			return ResponseEntity.status(200).body(catalogService.getProductById(id));
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ControllerException(exception.getMessage(), exception);
		}
	}
	
	@GetMapping("/getCategory/{id}")
	public ResponseEntity<Object> getCategoryById(@PathVariable Long id) throws ControllerException {
		try {
			return ResponseEntity.status(200).body(catalogService.getCategoryById(id));
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ControllerException(exception.getMessage(), exception);
		}
	}
	
	@GetMapping("/getAttribute/{id}")
	public ResponseEntity<Object> getAttributeById(@PathVariable Long id) throws ControllerException {
		try {
			return ResponseEntity.status(200).body(catalogService.getAttributeById(id));
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ControllerException(exception.getMessage(), exception);
		}
	}
}
