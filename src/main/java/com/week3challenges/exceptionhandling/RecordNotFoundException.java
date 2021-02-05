package com.week3challenges.exceptionhandling;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends  RuntimeException{
	 static final long serialVersionUID = 1L;
	public RecordNotFoundException() {
       
    }
	public RecordNotFoundException(String exception) {
        super(exception);
    }
}
