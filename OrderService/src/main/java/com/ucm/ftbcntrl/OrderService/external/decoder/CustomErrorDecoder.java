package com.ucm.ftbcntrl.OrderService.external.decoder;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucm.ftbcntrl.OrderService.exceptions.CustomeException;
import com.ucm.ftbcntrl.OrderService.external.response.ErrorResponse;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	private static final Logger log = LoggerFactory.getLogger(CustomErrorDecoder.class);

	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper objectMapper = new ObjectMapper();
		log.info("::{}", response.request().url());
		log.info("::{}", response.request().headers());

		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(),
					ErrorResponse.class);
	
		return new CustomeException(errorResponse.getErrorMessage(), 
				        			errorResponse.getErrorCode(), 
				        			response.status());
				
		} catch (IOException e) {
	
			throw new CustomeException("Internal Server Error","INTERNAL_SERVER_ERROR",500);
		}
	}
}
