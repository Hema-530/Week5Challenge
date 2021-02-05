package com.week3challenges.exceptionhandling;

import java.util.List;

public class    ErrorRespone{
	private String message;
	private List<String> details2;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails2() {
		return details2;
	}
	public void setDetails2(List<String> details2) {
		this.details2 = details2;
	}
	public ErrorRespone(String message, List<String> details2) {
		super();
		this.message = message;
		this.details2 = details2;
	}
	
	
}