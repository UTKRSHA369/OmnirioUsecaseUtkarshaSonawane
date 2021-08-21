package com.example.omnirio.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.omnirio.exceptions.DataNotFoundException;
import com.example.omnirio.exceptions.ServiceException;
import com.example.omnirio.models.Attribute;
import com.example.omnirio.models.Category;
import com.example.omnirio.models.Product;
import com.example.omnirio.repositories.AttributeRepository;
import com.example.omnirio.repositories.CategoryRepository;
import com.example.omnirio.repositories.ProductRepository;
import com.example.omnirio.services.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService{
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogServiceImpl.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	AttributeRepository attributeRepository;
	
	@Transactional
	@Override
	public Attribute createAttribute(Attribute attribute) throws ServiceException {
		try {
			LOGGER.info("Creating attribute: " + attribute);
			return attributeRepository.saveAndFlush(attribute);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
	
	@Transactional
	@Override
	public Category createCategory(Category category) throws ServiceException {
		try {
			LOGGER.info("Creating category: " + category);
			return categoryRepository.saveAndFlush(category);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
	
	@Transactional
	@Override
	public Product createProduct(Product product) throws ServiceException {
		try {
			LOGGER.info("Creating product: " + product);
			return productRepository.saveAndFlush(product);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public Product getProductById(Long id) throws ServiceException, DataNotFoundException {
		try {
			LOGGER.info("Getting product: " + id);
			Optional<Product> optional = productRepository.findById(id);
			if (optional.isPresent())
				return optional.get();
			else 
				throw new DataNotFoundException();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public Category getCategoryById(Long id) throws ServiceException, DataNotFoundException {
		try {
			LOGGER.info("Getting product: " + id);
			Optional<Category> optional = categoryRepository.findById(id);
			if (optional.isPresent())
				return optional.get();
			else 
				throw new DataNotFoundException();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public Attribute getAttributeById(Long id) throws ServiceException, DataNotFoundException {
		try {
			LOGGER.info("Getting product: " + id);
			Optional<Attribute> optional = attributeRepository.findById(id);
			if (optional.isPresent())
				return optional.get();
			else 
				throw new DataNotFoundException(new DataNotFoundException());
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
}
