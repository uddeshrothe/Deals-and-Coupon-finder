package com.coupons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupons.model.Customer;
import com.coupons.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public void update(Customer customer, long id) {
		customerRepository.save(customer);
	}
	
	public void saveOrUpdate(Customer customer) {
		customerRepository.save(customer);
	}
}
