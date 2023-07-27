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
    private UserService userService;

    @Autowired
    public IssueService(IssueRepository issueRepository, UserService userService) {
        this.issueRepository = issueRepository;
        this.userService = userService;
    }

 

    public Issue addIssue(String username, String description, LocalDate targetDate, boolean done) {
    	User user = userService.getUserByUsername(username); // Assuming you have a UserRepository to find the user
    	if (user == null) {
            // Handle the case where the user doesn't exist with the given username.
            return null;
        }
    	Issue issue = new Issue(description, targetDate, done, user);
    	issueRepository.save(issue);
        return issue;
    }

    public Issue deleteIssue(Long id) {
    	Issue issue = issueRepository.findById(id).orElse(null);
        issueRepository.deleteById(id);
        return issue;
    }

    public Issue getIssue(Long id) {
        return issueRepository.findById(id).orElse(null);
    }
    
    public List<Issue> getIssues(String username) {
        return issueRepository.findByUserUsernameIgnoreCase(username);
    }

    public void updateIssue(Issue issue) {
        issueRepository.save(issue);
    }
}
