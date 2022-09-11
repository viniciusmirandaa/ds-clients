package com.devsuperior.client.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.client.services.exceptions.DatabaseException;
import com.devsuperior.client.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionsHandler {

	private static HttpStatus httpStatus;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandartError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
		StandartError err = new StandartError();
		setHttpStatus(HttpStatus.NOT_FOUND);
		err.setTimestamp(Instant.now());
		err.setStatus(getHttpStatus().value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(getHttpStatus()).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandartError> entityNotFound(DatabaseException e, HttpServletRequest request){
		StandartError err = new StandartError();
		setHttpStatus(HttpStatus.BAD_REQUEST);
		err.setTimestamp(Instant.now());
		err.setStatus(getHttpStatus().value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(getHttpStatus()).body(err);
	}

	public static HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public static void setHttpStatus(HttpStatus httpStatus) {
		ExceptionsHandler.httpStatus = httpStatus;
	}
	
	
}
