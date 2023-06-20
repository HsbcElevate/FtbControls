package com.ucm.ftbcntrl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ucm.ftbcntrl.model.ErrorResponse;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handlePoductServiceException(ProductServiceCustomException exception){
		ErrorResponse errorresponse = new ErrorResponse();
		errorresponse.setErrorMessage(exception.getMessage());
		errorresponse.setErrorCode(exception.getErrorCode());
		
		return new ResponseEntity<ErrorResponse>(errorresponse, HttpStatus.NOT_FOUND) ;
		
	}
	
	
}
