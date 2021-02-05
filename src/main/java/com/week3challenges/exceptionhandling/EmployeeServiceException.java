package com.week3challenges.exceptionhandling;

public class EmployeeServiceException extends Exception{
	static final long serialVersionUID = -470180507998010368L;

	public EmployeeServiceException() {
		super();
	}

	public EmployeeServiceException(final String message) {
		super(message);
	}
}
