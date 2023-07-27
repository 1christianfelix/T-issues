package com.christian.tissues.tissuesbe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.christian.tissues.tissuesbe.model.User;
import com.christian.tissues.tissuesbe.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users")
	User newUser(@RequestBody User newUser) {
			return userService.createUser(newUser);
		}
	
	@GetMapping("/users")
	List<User> getUser() {
		return userService.getUsers();
	}
	
	
	@DeleteMapping("/users/{id}")
	Optional<User> deleteUser(@PathVariable Long id) {
		
		Optional<User> deleted = userService.deleteUser(id);
		
		return deleted;
	}

}
