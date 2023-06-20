package com.ucm.ftbcntrl.OrderService.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ucm.ftbcntrl.OrderService.exceptions.CustomeException;
import com.ucm.ftbcntrl.OrderService.external.response.ErrorResponse;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(CustomeException.class)
	public ResponseEntity<ErrorResponse> handleCustomeException(CustomeException exception){
	
		ErrorResponse errorresponse = new ErrorResponse();
		errorresponse.setErrorMessage(exception.getMessage());
		errorresponse.setErrorCode(exception.getErrorCode());
		
		return new ResponseEntity<ErrorResponse>(errorresponse, HttpStatus.valueOf(exception.getStatus()));
		
	}
	
	
}
