package com.java.maven.UserValidationLambda;

public class InvalidUserException extends Exception {
	enum ExceptionType{
		INVALID_FIRST_NAME,INVALID_LAST_NAME,INVALID_EMAIL,INVALID_MOBILE,INVALID_PASSWORD;
	}
	ExceptionType type;
	public InvalidUserException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}

}
