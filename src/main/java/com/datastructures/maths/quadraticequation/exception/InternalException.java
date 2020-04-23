package com.datastructures.maths.quadraticequation.exception;

import lombok.Data;

@Data
public class InternalException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 296734141680955421L;
	private final int outcomeCode;
	private final String outcomeMessage;
	private final String developerMessage;

}
