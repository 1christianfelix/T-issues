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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian.tissues.tissuesbe.model.User;
import com.christian.tissues.tissuesbe.model.UserLoginRequest;
import com.christian.tissues.tissuesbe.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("")
	User newUser(@RequestBody @Valid  User newUser) {
			return userService.createUser(newUser);
		}
	
	@PostMapping("/login")
	ResponseEntity<User> loginUser(@RequestBody UserLoginRequest loginInfo) {
		
		User user = userService.login(loginInfo);
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("")
	List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User currUser = userService.getUser(id);
        if (currUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currUser, HttpStatus.OK);
    }
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		
		User delUser = userService.deleteUser(id);
        if (delUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(delUser, HttpStatus.OK);
	}

}
