package com.ni.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeNotFoundException(EmployeeNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
	}
	
	@ExceptionHandler(EmployeeNotCreatedException.class)
	public ResponseEntity<String> employeeNotCreatedException(EmployeeNotCreatedException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		
	}
	
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<String> employeeAlreadyExistsException(EmployeeAlreadyExistsException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> employeeAlreadyExistsException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> httMessageConversionException(HttpMessageNotReadableException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your payload is not a valid representation. Please check for error.");
		
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleGlobalException(Throwable t){
		System.out.println("Executing global exception...");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t.getMessage());
		
	}

}
