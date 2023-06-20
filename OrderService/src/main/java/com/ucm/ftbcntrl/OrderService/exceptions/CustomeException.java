package com.ucm.ftbcntrl.OrderService.exceptions;

public class CustomeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private int status;
	
	
	public CustomeException(String message, String errorCode, int status) {
		super(message);
		this.errorCode=errorCode;
		this.status=status;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
