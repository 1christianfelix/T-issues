package com.christian.tissues.tissuesbe.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.christian.tissues.tissuesbe.model.Issue;

@Service
public class IssueService {
	
	private static List<Issue> issues = new ArrayList<>();
	
	private static int issuesCount = 0;
	
	static {
		issues.add(new Issue(++issuesCount, "in28minutes","Get AWS Certified", 
							LocalDate.now().plusYears(10), false ));
		issues.add(new Issue(++issuesCount, "in28minutes","Learn DevOps", 
				LocalDate.now().plusYears(11), false ));
		issues.add(new Issue(++issuesCount, "in28minutes","Learn Full Stack Development", 
				LocalDate.now().plusYears(12), false ));
	}

//	Predicate is acting as a lambda function and we're using Issue as type of issue
	public List<Issue> findByUsername(String username){
		Predicate<? super Issue> predicate =
						issue -> issue.getUsername().equalsIgnoreCase(username);
		return issues.stream().filter(predicate).toList();
	}
	
	public Issue addIssue(String username, String description, LocalDate targetDate, boolean done) {
		Issue issue = new Issue(++issuesCount, username, description, targetDate, done);
		issues.add(issue);
		return issue;
	}
	
	public void deleteById(int id) {
		Predicate<? super Issue> predicate = issue -> issue.getId() == id;
		issues.removeIf(predicate);
	}
	
	public Issue findById(int id) {
		Predicate<? super Issue> predicate = issue -> issue.getId() == id;
		Issue issue = issues.stream().filter(predicate).findFirst().get();
		return issue;
	}
	
	public void updateTodo(Issue issue) {
		deleteById(issue.getId());
		issues.add(issue);
	}
}
