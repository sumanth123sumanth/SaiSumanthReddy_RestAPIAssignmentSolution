package com.greatlearning.employeemanagement.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.model.Employee;
import com.greatlearning.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/list")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees();
		return employees;
	}

	@RequestMapping("/employee/{id}")
	public Employee showFormForUpdate(@PathVariable("id") int id) {
		return employeeService.findById(id);
	}

	@PutMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee emp) {
		Employee employee = employeeService.findById(emp.getId());
		if (employee != null) {
			employee.setFirstname(emp.getFirstname());
			employee.setLastname(emp.getLastname());
			employee.setEmail(emp.getEmail());
		}
		return employeeService.save(employee);
	}

	@PostMapping("/save")
	public Employee save(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}

	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable("id") int id) {
		employeeService.deleteById(id);
		return "Deleted employee id - " + id;
	}

	@RequestMapping(value = "/search/{firstname}", method = RequestMethod.GET)
	public List<Employee> search(@PathVariable("firstname") String firstname) {
		if (!firstname.isBlank()) {
			List<Employee> employees = employeeService.search(firstname);
			return employees;
		}
		return null;
	}

	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	public List<Employee> getAllEmployeesAndSort(@RequestParam("order") String order) {
		List<Employee> employees = employeeService.findAllEmployees();
		if ("asc".equalsIgnoreCase(order)) {
			Collections.sort(employees, new Comparator<Employee>() {

				public int compare(Employee o1, Employee o2) {
					return o1.getFirstname().compareTo(o2.getFirstname());
				}
			});
		} else if ("desc".equalsIgnoreCase(order)) {
			Collections.sort(employees, new Comparator<Employee>() {

				public int compare(Employee o1, Employee o2) {
					return o2.getFirstname().compareTo(o1.getFirstname());
				}
			});
		}
		return employees;
	}
}
