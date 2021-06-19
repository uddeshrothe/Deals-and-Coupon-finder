package com.coupons.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupons.models.User;
import com.coupons.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> allAccess() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/admin")
	public List<User> adminAccess() {
		return userRepository.findAll();
	}
}
