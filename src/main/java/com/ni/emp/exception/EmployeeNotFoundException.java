package com.ni.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 
 * @author Parthiban
 * class to handle exception while the employee not found.
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor.
	 * @param msg
	 */
	public EmployeeNotFoundException(String msg) {
		super(msg);
		
	}

}
