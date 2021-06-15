package com.coupons.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.coupons.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

	public Customer findByName(String name);
	
}
