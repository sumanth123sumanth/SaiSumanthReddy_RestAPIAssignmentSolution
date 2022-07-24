package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagement.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String name);
}
