package com.ni.emp.exception;



/**
 * Exception class to handle the employee creation failures.
 * @author Parthiban
 *
 */
public class EmployeeNotCreatedException extends RuntimeException {
	
	
	/**
	 * default serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Constructor.
	 * @param msg
	 */
	public EmployeeNotCreatedException(String msg) {
		super(msg);
	}

}
