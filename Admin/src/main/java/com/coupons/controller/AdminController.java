package com.coupons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coupons.model.Admin;
import com.coupons.repository.AdminRepository;
import com.google.common.base.Optional;

@RestController
public class AdminController {
	
	@Autowired
	public AdminRepository adminRepository;
	
	@GetMapping(value = "/all")
	public List<Admin> getAllStudents(){
		return adminRepository.findAll();
	}
	@GetMapping(value = "/name/{name}")
	public Admin getAdmin(@PathVariable("name") String name) {
		return adminRepository.findByName(name);
	}
	
	@PostMapping(value = "/create")
	public String createAdmin(@RequestBody Admin admin) {
		
		Admin insertedAdmin = adminRepository.insert(admin);
		return "Admin Created: " + insertedAdmin.getName();
	}
	
	@DeleteMapping(value = "/remove/{id}")
	public void deleteCustomer(@PathVariable("id") long id) {
		adminRepository.deleteById(id);
	}
	
	@PutMapping(value = "/admin/{id}")
	public Admin update(@RequestBody Admin admin, @PathVariable long id, String email, String name, String password) {
		admin.setId(id);
		admin.setEmail(email);
		admin.setName(name);
		admin.setPassword(password);
		return adminRepository.save(admin);
		
	}
	
}