package com.products.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.entities.Product;
import com.products.exception.ProductCollectionException;
import com.products.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	

public void createProduct(Product product) throws ProductCollectionException  {
		
		Optional<Product> todoOptional =productRepository.findById(product.getId());
		if(todoOptional.isPresent()) {
			throw new ProductCollectionException(ProductCollectionException.ProductAlreadyExists());
		}else {
			//product.setCreatedAt(new Date(System.currentTimeMillis()));
			productRepository.save(product);
		}
		
	}
	 
}
