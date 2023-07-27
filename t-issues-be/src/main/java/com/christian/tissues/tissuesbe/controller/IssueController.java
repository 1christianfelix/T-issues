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
import org.springframework.web.bind.annotation.RestController;

import com.christian.tissues.tissuesbe.model.Issue;
import com.christian.tissues.tissuesbe.model.createIssueRequest;
import com.christian.tissues.tissuesbe.service.IssueService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class IssueController {

	private IssueService issueService;

	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}
	

	@PostMapping("/issues")
	public ResponseEntity<Issue> addIssue(@RequestBody createIssueRequest request){
		Issue issue = issueService.addIssue(
	            request.getUsername(),
	            request.getDescription(),
	            request.getTargetDate(),
	            request.isDone()
	        );
		return new ResponseEntity<>(issue, HttpStatus.CREATED);

	}
    
}
