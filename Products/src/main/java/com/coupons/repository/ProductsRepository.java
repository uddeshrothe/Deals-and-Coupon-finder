package com.coupons.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coupons.model.Products;

public interface ProductsRepository extends MongoRepository<Products, String> {

	Products findByProductName(String name);

	void deleteById(int id);

	

}
