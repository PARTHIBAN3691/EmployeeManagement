package com.ni.emp.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyExistsException(String msg) {
		super(msg);
	}

}
