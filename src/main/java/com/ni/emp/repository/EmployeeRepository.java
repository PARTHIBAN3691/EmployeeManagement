package com.ni.emp.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ni.emp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByFirstNameAndLastNameAndDob(String firstName, String lastName, Date dob);

}
