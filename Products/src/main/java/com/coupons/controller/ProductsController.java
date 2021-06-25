package com.coupons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupons.model.Products;
import com.coupons.repository.ProductsRepository;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping
public class ProductsController {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@GetMapping(value = "/all")
	public List<Products> getAllProducts(){
		return productsRepository.findAll();
	}
	@GetMapping(value = "/name/{productName}")
	public Products getProducts(@PathVariable("productName") String productName) {
		return productsRepository.findByProductName(productName);
	}
	
	@PostMapping(value = "/create")
	public String createProducts(@RequestBody Products products) {
		
		Products insertedProduct= productsRepository.insert(products);
		return "Product Created: " + insertedProduct.getProductName();
	}
	
	@DeleteMapping(value = "/remove/{id}")
	public void deleteProducts(@PathVariable("id") int id) {
		productsRepository.deleteById(id);
	}
	
	@PutMapping(value = "/admin/{id}")
	public Products update(@RequestBody Products products, @PathVariable int id, String productName, int productCost) {
		products.setId(id);
		products.setProductName(productName);
		products.setProductCost(productCost);
		productsRepository.save(products);
		
		return products;
		
	}

}
