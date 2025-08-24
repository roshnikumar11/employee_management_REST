package com.jsp.emprest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.emprest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByRoleContaining(String role);

}