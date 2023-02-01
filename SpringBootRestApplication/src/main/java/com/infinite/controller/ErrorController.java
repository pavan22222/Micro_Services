package com.infinite.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infinite.entity.ErrorDetails;

@RestControllerAdvice
public class ErrorController {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> throwException(Exception ex){
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setError(ex.getMessage());
		errorDetails.setStatus(400);
		errorDetails.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);		
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> throwIllegalArgumentException(Exception ex){
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setError(ex.getMessage());
		errorDetails.setStatus(500);
		errorDetails.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);		
	}

}
