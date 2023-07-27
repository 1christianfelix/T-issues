package com.christian.tissues.tissuesbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christian.tissues.tissuesbe.model.Issue;
import com.christian.tissues.tissuesbe.model.User;
import com.christian.tissues.tissuesbe.repository.IssueRepository;
import com.christian.tissues.tissuesbe.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;


//Service serves as middleware
@Service
public class IssueService {

    private final IssueRepository issueRepository;
    private UserRepository userRepository;

    @Autowired
    public IssueService(IssueRepository issueRepository, UserRepository userRepository) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
    }

    public List<Issue> findByUsername(String username) {
        return issueRepository.findByUserUsernameIgnoreCase(username);
    }

    public Issue addIssue(String username, String description, LocalDate targetDate, boolean done) {
    	User user = userRepository.findByUsername(username); // Assuming you have a UserRepository to find the user
    	if (user == null) {
            // Handle the case where the user doesn't exist with the given username.
            throw new RuntimeException("User with username " + username + " not found!");
        }
    	Issue issue = new Issue(description, targetDate, done, user);
        return issueRepository.save(issue);
    }

    public void deleteById(Long id) {
        issueRepository.deleteById(id);
    }

    public Issue findById(Long id) {
        return issueRepository.findById(id).orElse(null);
    }

    public void updateIssue(Issue issue) {
        issueRepository.save(issue);
    }
}
