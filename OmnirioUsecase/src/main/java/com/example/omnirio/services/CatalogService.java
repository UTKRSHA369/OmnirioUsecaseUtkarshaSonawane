package com.example.omnirio.services;

import com.example.omnirio.exceptions.DataNotFoundException;
import com.example.omnirio.exceptions.ServiceException;
import com.example.omnirio.models.Attribute;
import com.example.omnirio.models.Category;
import com.example.omnirio.models.Product;

public interface CatalogService {

	Attribute createAttribute(Attribute attribute) throws ServiceException;

	Category createCategory(Category category) throws ServiceException;

	Product createProduct(Product product) throws ServiceException;

	Product getProductById(Long id) throws ServiceException, DataNotFoundException;

	Category getCategoryById(Long id) throws ServiceException, DataNotFoundException;

	Attribute getAttributeById(Long id) throws ServiceException, DataNotFoundException;

}
