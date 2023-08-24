package com.ni.emp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ni.emp.exception.EmployeeAlreadyExistsException;
import com.ni.emp.model.Employee;
import com.ni.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository empRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository empRepository) {
		this.empRepository= empRepository;
	}

	public Optional<Employee> getEmployee(Long empId) {
		return empRepository.findById(empId);
	}

	public Optional<Employee> createEmployee(Employee emp) {
		exists(emp);
		return Optional.ofNullable(empRepository.save(emp));
	}

	public boolean exists(Employee emp) {
		if (empRepository.existsByFirstNameAndLastNameAndDob(emp.getFirstName(), emp.getLastName(), emp.getDob())) {
			throw new EmployeeAlreadyExistsException("The employee already exists. Please contact support team.");
		}
		return true;
	}
}
