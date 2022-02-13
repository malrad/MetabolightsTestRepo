package com.ebi.metabolights.study.exception;

public class StudyExceptionResponse extends RuntimeException{
	
	public StudyExceptionResponse(String message) {
		super(message);
	}

	public StudyExceptionResponse(String message, Throwable cause) {
		super(message, cause);
	}
}
