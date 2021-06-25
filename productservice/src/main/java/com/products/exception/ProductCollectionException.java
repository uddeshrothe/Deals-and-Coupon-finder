package com.products.exception;

public class ProductCollectionException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductCollectionException(String message)
	{
		super(message);
	}
	
	public static String NotFoundException(String id)
	{
		return "Product with "+id+"not found";
	}
	
	public static String ProductAlreadyExists() {
		return "Product with given Id already exists";
	}

}

