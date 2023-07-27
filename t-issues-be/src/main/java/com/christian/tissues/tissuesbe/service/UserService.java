package com.christian.tissues.tissuesbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christian.tissues.tissuesbe.model.Issue;
import com.christian.tissues.tissuesbe.model.User;
import com.christian.tissues.tissuesbe.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(User newUser) {
    	return userRepository.save(newUser);
    }
    
    public List<User> getUsers(){
    	return userRepository.findAll();
    }
    

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public User getUserByUsername(String username) {
    	return userRepository.findByUsername(username);
    }

    public User deleteUser(Long id) {
    	userRepository.deleteById(id);
    	User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public void updateUser(User user) {
    	userRepository.save(user);
    }
}