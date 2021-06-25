package com.couponsservice.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.couponsservice.entities.Coupon;
import com.couponsservice.repository.CouponRepository;
import com.couponsservice.services.CouponService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping
public class CoController {

	@Autowired
	private CouponService couponService;
	
	@Autowired
	private CouponRepository couponRepository;
	
	@GetMapping("/getCoupon")
	@ApiOperation(value="Get all coupons",
			notes="Fetch all coupons from the database",
			response=Coupon.class)
	public ResponseEntity<?> getCoupon(){
		List<Coupon> coupon =  couponRepository.findAll();
		return new ResponseEntity<List<Coupon>>(coupon, HttpStatus.OK);
	}
	
	@GetMapping("/getSingleCoupon/{id}")
	public ResponseEntity<?> getSingleCoupon(@PathVariable("id") String id){
		Optional<Coupon> couponOptional = couponRepository.findById(id);
		if(couponOptional.isPresent()) {
			return new ResponseEntity<>(couponOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Coupon Not found with id "+id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/saveCoupon")
	@ApiOperation(value="Save coupon",
	notes="Save coupons in the database",
	response=Coupon.class)
	public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon) {
		//return couponService.save(coupon);
		try {
			couponService.createCoupon(coupon);
			return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} 
	}
	
	@PutMapping("/updateCoupon/{id}")
	public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Coupon coupon){
		Optional<Coupon> couponOptional = couponRepository.findByIds(id);
		if(couponOptional.isPresent()) {
			Coupon todoToSave = couponOptional.get();
			todoToSave.setId(coupon.getId() != null ? coupon.getId() : todoToSave.getId());
			todoToSave.setCouponCode(coupon.getCouponCode() != null ? coupon.getCouponCode() : todoToSave.getCouponCode());
			//todoToSave.setId(new Date(System.currentTimeMillis()));
			couponRepository.save(todoToSave);
			return new ResponseEntity<>(todoToSave, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Coupon Not found with id "+id, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteCoupon/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id){
		try {
			couponRepository.deleteById(id);
			return new ResponseEntity<>("Successfully deleted with id "+id, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
