package com.week3challenges.exceptionhandling;

import java.net.http.HttpHeaders;
import java.util.ArrayList;

import java.util.List;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;





@ControllerAdvice
public class ExceptionAdvice  extends Exception {

	 static final long serialVersionUID = 1L;


	@ResponseStatus(HttpStatus.NOT_FOUND)
	  @ExceptionHandler(RecordNotFoundException.class)
	    public ResponseEntity<?> resourceNotFoundException(RecordNotFoundException ex, WebRequest request) {
		  ExceptionResponse errorDetails = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorRespone error = new ErrorRespone("Validation Failed", details);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }
}