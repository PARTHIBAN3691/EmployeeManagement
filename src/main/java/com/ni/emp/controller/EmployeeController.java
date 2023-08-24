package com.ni.emp.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ni.emp.exception.EmployeeAlreadyExistsException;
import com.ni.emp.exception.EmployeeNotCreatedException;
import com.ni.emp.exception.EmployeeNotFoundException;
import com.ni.emp.exception.EmployeeSearchException;
import com.ni.emp.model.Employee;
import com.ni.emp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") Long empId) {
		Optional<Employee> emp = Optional.empty();
		try {
			emp = employeeService.getEmployee(empId);
			if (emp.isEmpty()) {
				throw new EmployeeNotFoundException("Employee Not Found");
			}
		} catch(EmployeeNotFoundException e) {
			throw e;
		}catch (Throwable t) {
			throw new EmployeeSearchException(
					"There is an error while searching for employee. Please contact administrator.");
		}
		return ResponseEntity.ok(emp.get());
	}

	@PostMapping("/new")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee emp) {
		Optional<Employee> empRecord = Optional.empty();
		try {
			empRecord = employeeService.createEmployee(emp);

		} catch (HttpMessageConversionException hmce) {
			throw new HttpMessageConversionException("Your payload is not a valid representation. Please check for error.");
		} catch (EmployeeAlreadyExistsException ea) {
			throw ea;
		} catch (DataIntegrityViolationException dve) {
			throw new DataIntegrityViolationException("Please fill all the mandatory fields.");
		} catch (Throwable t) {
			throw new EmployeeNotCreatedException(
					"There is an error while creating the employee. Please contact administrator.");
		}
		return ResponseEntity.ok(empRecord.get());
	}

}
