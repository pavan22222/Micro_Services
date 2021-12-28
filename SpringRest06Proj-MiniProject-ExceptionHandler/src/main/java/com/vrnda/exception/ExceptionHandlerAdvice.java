package com.vrnda.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(ComputerNotFoundException.class)
	public ResponseEntity<ErrorDetails> getInfo(ComputerNotFoundException cnfe){
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(LocalDateTime.now(),cnfe.getMessage(),"404"),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> getInfo(Exception e){
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(LocalDateTime.now(),e.getMessage(),"500"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@Data
	@AllArgsConstructor
	private class ErrorDetails{
		private LocalDateTime date;
		private String msg;
		private String code;
	}
}
