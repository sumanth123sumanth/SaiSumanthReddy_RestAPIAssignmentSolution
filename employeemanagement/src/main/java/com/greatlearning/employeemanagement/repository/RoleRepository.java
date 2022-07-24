package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagement.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
