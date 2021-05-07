package com.example.demo.exception;
public class PatientNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(long id) {
		super("Patient with ID "+id+" is not found");
	}

	public PatientNotFoundException() {
		
	}

	
	
}