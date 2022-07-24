package com.greatlearning.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> search(String firstname) {
		return employeeRepository.findByFirstnameContainsAllIgnoreCase(firstname);
	}

}