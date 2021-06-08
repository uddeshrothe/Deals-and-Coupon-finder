package com.coupons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupons.model.Customer;
import com.coupons.repository.CustomerRepository;
import com.coupons.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService customerService;
	
	@GetMapping(value = "/all")
	public List<Customer> getAllStudents(){
		return customerRepository.findAll();
	}
	@GetMapping(value = "/name/{name}")
	public Customer getCustomer(@PathVariable("name") String name) {
		return customerRepository.findByName(name);
	}
	
	@PostMapping(value = "/create")
	public String createCustomer(@RequestBody Customer customer) {
		
		Customer insertedCustomer = customerRepository.insert(customer);
		return "Customer Created: " + insertedCustomer.getName();
	}
	
	@DeleteMapping(value = "/remove/{id}")
	public void deleteCustomer(@PathVariable("id") long id) {
		customerRepository.deleteById(id);
	}
	
	@PutMapping(value = "/customer")
	public Customer update(@RequestBody Customer customer) {
		
		customerService.saveOrUpdate(customer);
		return customer;
		
	}
	
}
