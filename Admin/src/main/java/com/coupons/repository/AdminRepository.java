package com.coupons.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.coupons.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, Long> {

	Admin findByName(String name);

}
