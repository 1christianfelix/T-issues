package com.christian.tissues.tissuesbe.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.christian.tissues.tissuesbe.model.Issue;
import com.christian.tissues.tissuesbe.service.IssueService;

@RestController
public class IssueController {

	private IssueService issueService;

	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}

	@GetMapping("/users/{username}/issues")
	public List<Issue> retrieveIssues(@PathVariable String username) {
		return issueService.findByUsername(username);
	}

	@GetMapping("/users/{username}/issues/{id}")
	public Issue retrieveIssue(@PathVariable String username,
			@PathVariable int id) {
		return issueService.findById(id);
	}

	/*
	 * ResponseEntity.noContent() creates a ResponseEntity with an HTTP status
	 * code of 204 (No Content). This status code is used when the server has
	 * successfully fulfilled the request, but there is no content to send in
	 * the response payload.
	 */
	@DeleteMapping("/users/{username}/issues/{id}")
	public ResponseEntity<Void> deleteIssue(@PathVariable String username,
			@PathVariable int id) {
		issueService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/issues/{id}")
	public Issue updateIssue(@PathVariable String username,
			@PathVariable int id, @RequestBody Issue issue) {
		issueService.updateIssue(issue);
		return issue;
	}
	
	@PostMapping("/users/{username}/issues")
	public Issue createIssue(@PathVariable String username,
			@PathVariable int id, @RequestBody Issue issue) {
		Issue createdIssue = issueService.addIssue(username, issue.getDescription(), issue.getTargetDate(), issue.isDone());
		return createdIssue;
	}
}
