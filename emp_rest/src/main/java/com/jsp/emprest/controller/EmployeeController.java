package com.jsp.emprest.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.emprest.entity.Employee;
import com.jsp.emprest.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/employees")
	@Operation(summary="Save an Employee Record")
	public ResponseEntity<Map<String, Object>> saveEmployee(@RequestBody Employee employee) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("message", "Data saved successfully");
		map.put("content", service.saveRecords(employee));
		return ResponseEntity.status(201).body(map);
	}

	@GetMapping("/employees")
	@Operation(summary="Fetch Employees Record")
	public ResponseEntity<Map<String, Object>> fetchEmployee(@RequestParam(defaultValue = "id") String sort,
			@RequestParam(defaultValue = "false") boolean desc, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String role) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("message", "Data fetched successfully");
		map.put("content", service.fetchRecords(sort, desc, page, size, role));
		return ResponseEntity.status(200).body(map);
	}

	@DeleteMapping("/employees/{id}")
	@Operation(summary="Fetch an Employee Record")
	public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable long id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		service.deleteRecord(id);
		map.put("message", "Data deleted successfully");
		return ResponseEntity.status(HttpStatus.OK).body(map);
//		return ResponseEntity.status(204).body(map);
	}

	@PutMapping("/employees")
	@Operation(summary="Update an Employee Record Completely")
	public ResponseEntity<Map<String, Object>> updateEmployee(@RequestBody Employee employee) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("message", "Data updated sucessfully");
		map.put("content", service.saveRecords(employee));

		return ResponseEntity.status(200).body(map);
	}

	@PatchMapping("/employees/{id}")
	@Operation(summary="Update an Employee Record Partially")
	public ResponseEntity<Map<String, Object>> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("message", "Data updated sucessfully");
		map.put("content", service.updateRecords(employee, id));

		return ResponseEntity.status(200).body(map);
	}
}