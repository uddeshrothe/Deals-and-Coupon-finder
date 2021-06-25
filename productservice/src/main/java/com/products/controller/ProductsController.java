package com.products.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.products.entities.Product;
import com.products.repository.ProductRepository;
import com.products.services.ProductService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping
public class ProductsController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/getProduct")
	@ApiOperation(value="Get all products",
			notes="Fetch all products from the database",
			response=Product.class)
	public ResponseEntity<?> getProduct(){
		List<Product> product =  productRepository.findAll();
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
	
	@GetMapping("/getSingleProduct/{id}")
	public ResponseEntity<?> getSingleProduct(@PathVariable("id") String id){
		Optional<Product> productOptional = productRepository.findById(id);
		if(productOptional.isPresent()) {
			return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Product Not found with id "+id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/saveProduct")
	@ApiOperation(value="Save product",
	notes="Save products in the database",
	response=Product.class)
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		//return productService.save(product);
		try {
			productService.createProduct(product);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} 
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Product product){
		Optional<Product> productOptional = productRepository.findByIds(id);
		if(productOptional.isPresent()) {
			Product todoToSave = productOptional.get();
			todoToSave.setId(product.getId() != null ? product.getId() : todoToSave.getId());
			todoToSave.setProductName(product.getProductName() != null ? product.getProductName():todoToSave.getProductName());
			todoToSave.setProductCost(product.getProductCost());
			productRepository.save(todoToSave);
			return new ResponseEntity<>(todoToSave, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Product Not found with id "+id, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id){
		try {
			productRepository.deleteById(id);
			return new ResponseEntity<>("Successfully deleted with id "+id, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
