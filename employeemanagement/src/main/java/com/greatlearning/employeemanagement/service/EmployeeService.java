package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.model.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();

	public Employee findById(int id);

	public Employee save(Employee emp);

	public void deleteById(int id);

	public List<Employee> search(String firstname);

}