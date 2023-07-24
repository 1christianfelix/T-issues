package com.christian.tissues.tissuesbe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Issue retrieveIssue(@PathVariable String username, @PathVariable int id) {
		return issueService.findById(id);
	}
	
	@DeleteMapping("/users/{username}/issues/{id}")
	public Issue deleteIssue(@PathVariable String username, @PathVariable int id) {
		return issueService.findById(id);
		issueService.deleteById(id);
	}
}
