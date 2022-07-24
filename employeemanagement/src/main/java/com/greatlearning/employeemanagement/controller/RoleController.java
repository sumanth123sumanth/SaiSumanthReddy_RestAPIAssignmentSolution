package com.greatlearning.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@PostMapping("/save")
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}
}
