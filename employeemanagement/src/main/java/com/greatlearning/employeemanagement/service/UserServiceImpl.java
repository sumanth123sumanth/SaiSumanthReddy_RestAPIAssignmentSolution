package com.greatlearning.employeemanagement.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.model.User;
import com.greatlearning.employeemanagement.repository.RoleRepository;
import com.greatlearning.employeemanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public User save(User user) {

		Set<Role> roles = user.getRoles();

		Set<Role> rolesFromRepo = new HashSet<Role>();
		for (Role role : roles) {
			Role roleUser = roleRepository.findById(role.getId()).get();
			rolesFromRepo.add(roleUser);
		}
		user.getRoles().clear();
		for (Role role : rolesFromRepo) {
			user.addRole(role);
		}

		return userRepository.save(user);
	}

}
