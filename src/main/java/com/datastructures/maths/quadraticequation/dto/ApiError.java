package com.datastructures.maths.quadraticequation.dto;

import lombok.Data;

@Data
public class ApiError {
	
	private int outcomeCode;
	private String internalMessage;
	private String developerMessage;
	

}
