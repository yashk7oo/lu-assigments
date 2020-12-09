package com.training.utils;
import com.training.Student;

public class RangeCheckException extends java.lang.Exception {
	private String message;
	/**
	 * @param message
	 */
	public RangeCheckException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		
		return this.message;
	}
	
	

}
