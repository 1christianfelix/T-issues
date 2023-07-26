package com.christian.tissues.tissuesbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christian.tissues.tissuesbe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
