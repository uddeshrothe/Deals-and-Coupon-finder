package com.products.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	
	@Id
	private String id;
	
	private String productName;
	private int productCost;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String productName, int productCost) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCost = productCost;
	}
	
	
	

}
