package com.christian.tissues.tissuesbe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian.tissues.tissuesbe.model.Issue;
import com.christian.tissues.tissuesbe.model.User;
import com.christian.tissues.tissuesbe.model.createIssueRequest;
import com.christian.tissues.tissuesbe.repository.UserRepository;
import com.christian.tissues.tissuesbe.service.IssueService;
import com.christian.tissues.tissuesbe.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/issues")
public class IssueController {

	private IssueService issueService;
	private UserService userService;

	public IssueController(IssueService issueService, UserService userService) {
		this.issueService = issueService;
		this.userService = userService;
	}
	

	@GetMapping("/{username}")
	List<Issue> getIssues(@PathVariable String username){
		return issueService.getIssues(username);
	}
	
	@GetMapping("/{username}/{id}")
	public ResponseEntity<Issue> getIssue(@PathVariable Long id, @PathVariable String username){
		User user = userService.getUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Check if the issue with the given ID exists
        Issue issue = issueService.getIssue(id);
        if (issue == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
     // Check if the issue is associated with the user
        if (!issue.getUser().equals(user)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(issue, HttpStatus.OK);
	
	}
	
	@PostMapping("")
	public ResponseEntity<Issue> addIssue(@RequestBody createIssueRequest request){
		Issue issue = issueService.addIssue(
	            request.getUsername(),
	            request.getDescription(),
	            request.getTargetDate(),
	            request.isDone()
	        );
		if (issue == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(issue, HttpStatus.CREATED);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Issue> delIssue(@PathVariable Long id){
		Issue delIssue = issueService.deleteIssue(id);
        if (delIssue == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(delIssue, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Issue> updateIssue(@PathVariable Long id, @RequestBody Issue issue){
		Issue existingIssue = issueService.getIssue(id);
        if (existingIssue != null) {
            issue.setId(id);
            issueService.updateIssue(issue);
            return new ResponseEntity<>(existingIssue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
    
}
