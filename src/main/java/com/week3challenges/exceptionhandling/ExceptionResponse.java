package com.week3challenges.exceptionhandling;



public class ExceptionResponse {
	 String errorMessage;
	 String details;
	
	public ExceptionResponse(String message, String description) {
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
