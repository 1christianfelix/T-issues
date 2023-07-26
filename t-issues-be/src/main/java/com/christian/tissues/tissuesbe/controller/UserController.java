package com.christian.tissues.tissuesbe.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.christian.tissues.tissuesbe.model.User;
import com.christian.tissues.tissuesbe.repository.UserRepository;

@RestController
public class UserController {
	
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
			return userRepository.save(newUser);
		}
	

}
