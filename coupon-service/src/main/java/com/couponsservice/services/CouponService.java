package com.couponsservice.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couponsservice.entities.Coupon;
import com.couponsservice.exception.CouponCollectionException;
import com.couponsservice.repository.CouponRepository;

@Service
public class CouponService {

	@Autowired
	private CouponRepository couponRepository;
	

public void createCoupon(Coupon coupon) throws CouponCollectionException  {
		
		Optional<Coupon> todoOptional =couponRepository.findById(coupon.getId());
		if(todoOptional.isPresent()) {
			throw new CouponCollectionException(CouponCollectionException.CouponAlreadyExists());
		}else {
			//coupon.setCreatedAt(new Date(System.currentTimeMillis()));
			couponRepository.save(coupon);
		}
		
	}
	 
}
