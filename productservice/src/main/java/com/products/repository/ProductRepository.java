package com.products.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.products.entities.Product;

@Repository
public interface ProductRepository  extends MongoRepository<Product, String>{
	@Query("{'id' : ?0}")
	Optional<Product> findByIds(String todo);
}

