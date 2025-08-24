package com.jsp.employee.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String,Object>> handle400(){
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("error", "Data already exists");
		return ResponseEntity.status(400).body(map);
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Map<String,Object>> handle404(){
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("error", "Path does not exist");
		return ResponseEntity.status(404).body(map);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Map<String,Object>> handle405(){
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("error", "Method Not Allowed");
		return ResponseEntity.status(405).body(map);
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleNotFound(){
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("error", "Data Not Found");
		return ResponseEntity.status(404).body(map);
	}
}