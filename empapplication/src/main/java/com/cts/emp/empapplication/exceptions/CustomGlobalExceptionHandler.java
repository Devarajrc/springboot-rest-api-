package com.cts.emp.empapplication.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cts.emp.empapplication.responses.CustomErrorDetails;


@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails = new CustomErrorDetails();
		customErrorDetails.setDate(new Date());
		customErrorDetails.setDetails("From MethodArgumentNotValid Exception in GEH");
		customErrorDetails.setTitle(ex.getMessage());
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}

	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails = new CustomErrorDetails();
		customErrorDetails.setDate(new Date());
		customErrorDetails.setDetails("From httprequestMethodNotSupported Exception in GEH");
		customErrorDetails.setTitle(ex.getMessage());
		return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);

	}

	// UserNameNotFoundException
	@ExceptionHandler(UserNameNotFoundException.class)
	public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex,
			WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails();
		customErrorDetails.setDate(new Date());
		customErrorDetails.setDetails("From MethodArgumentNotValid Exception in GEH");
		customErrorDetails.setTitle(ex.getMessage());
		return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);

	}

	// ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails();
		customErrorDetails.setDate(new Date());
		customErrorDetails.setDetails("From MethodArgumentNotValid Exception in GEH");
		customErrorDetails.setTitle(ex.getMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);

	}
	
}
