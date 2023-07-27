package com.christian.tissues.tissuesbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christian.tissues.tissuesbe.model.Issue;

import java.util.List;


public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByUserUsernameIgnoreCase(String username);

}
