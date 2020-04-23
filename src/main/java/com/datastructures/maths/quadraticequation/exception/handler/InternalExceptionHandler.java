package com.datastructures.maths.quadraticequation.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.datastructures.maths.quadraticequation.dto.ApiError;
import com.datastructures.maths.quadraticequation.exception.InternalException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestControllerAdvice
public class InternalExceptionHandler extends ResponseEntityExceptionHandler {
	
	public InternalExceptionHandler() {
		super();
	}
	
	@ExceptionHandler(InternalException.class)
	protected ResponseEntity<ApiError> handleinternexc(Exception e, WebRequest req){
		
		ApiError obj = new ApiError();
		InternalException resp = (InternalException) e;
		
		obj.setOutcomeCode(resp.getOutcomeCode());
		obj.setInternalMessage(resp.getMessage());
		obj.setDeveloperMessage(resp.getDeveloperMessage());
		log.error("Internal Exception - OutcomeCode: " + resp.getMessage() + "Message " + resp.getOutcomeMessage());
		return new ResponseEntity<ApiError>(obj,HttpStatus.BAD_REQUEST);
	}

}
