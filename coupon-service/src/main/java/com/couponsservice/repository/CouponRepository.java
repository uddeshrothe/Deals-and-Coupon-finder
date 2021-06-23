package com.couponsservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.couponsservice.entities.Coupon;

@Repository
public interface CouponRepository  extends MongoRepository<Coupon, String>{
	@Query("{'id' : ?0}")
	Optional<Coupon> findByIds(String todo);
}

