package com.coupons.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Products {
	
	@Id
	private int id;
	
	private String productName;
	private int productCost;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int id, String productName, int productCost) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCost = productCost;
	}
	
	
	

}
