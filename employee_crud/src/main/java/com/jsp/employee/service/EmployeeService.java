package com.jsp.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jsp.employee.entity.Employee;
import com.jsp.employee.exception.DataNotFoundException;
import com.jsp.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public Employee saveRecords(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> fetchRecords(String sort, boolean desc, int page, int size, String role) {
		Sort sorting = desc ? Sort.by(sort).descending() : Sort.by(sort);// ascending() by default
		PageRequest pagination = PageRequest.of(page - 1, size, sorting);
		List<Employee> employees = new ArrayList<Employee>();
		if (role == null)
			employees = repository.findAll(pagination).getContent();
		else
			employees = repository.findByRoleContaining(role);
		if (employees.isEmpty())
			throw new DataNotFoundException();
		else
			return employees;
	}

	public void deleteRecord(long id) {
		repository.deleteById(id);
	}

	public Employee updateRecords(Employee employee, Long id) {
		Employee oldEmployee = repository.findById(id).orElseThrow(() -> new DataNotFoundException());
		if (employee.getAge() != null)
			oldEmployee.setAge(employee.getAge());
		if (employee.getMobile() != null)
			oldEmployee.setMobile(employee.getMobile());
		if (employee.getName() != null)
			oldEmployee.setName(employee.getName());
		if (employee.getRole() != null)
			oldEmployee.setRole(employee.getRole());
		if (employee.getSalary() != null)
			oldEmployee.setSalary(employee.getSalary());
		return repository.save(oldEmployee);
	}
	
	

}
