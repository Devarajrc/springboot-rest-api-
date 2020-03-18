package com.cts.emp.empapplication.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cts.emp.empapplication.responses.CustomErrorDetails;

public class GlobalRestControllerAdviceExceptionHandler {


	@ExceptionHandler(UserNameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomErrorDetails usernameNotFound(UserNameNotFoundException ex) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails();
		customErrorDetails.setDate(new Date());
		customErrorDetails.setDetails("From MethodArgumentNotValid Exception in GEH");
		customErrorDetails.setTitle(ex.getMessage());
		return customErrorDetails;
	}
}
