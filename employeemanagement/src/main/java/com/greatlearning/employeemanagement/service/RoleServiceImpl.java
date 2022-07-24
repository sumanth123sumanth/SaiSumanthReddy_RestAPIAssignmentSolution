package com.greatlearning.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.repository.RoleRepository;



@Service
public class RoleServiceImpl implements RoleService  {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

}
