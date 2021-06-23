package com.couponsservice.exception;

public class CouponCollectionException extends Exception {

	private static final long serialVersionUID = 1L;

	public CouponCollectionException(String message)
	{
		super(message);
	}
	
	public static String NotFoundException(String id)
	{
		return "Coupon with "+id+"not found";
	}
	
	public static String CouponAlreadyExists() {
		return "Coupon with given Id already exists";
	}

}

