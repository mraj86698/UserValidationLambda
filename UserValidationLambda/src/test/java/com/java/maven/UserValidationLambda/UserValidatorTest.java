package com.java.maven.UserValidationLambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserValidatorTest
{
	@Test
	public void givenAllDetails_WhenAllProper_ShouldReturnTrue() {
		try {
			boolean isValid = UserValidator.validate("Mohan","Raj","mraj86698@gmail.com","91 9374930453","Mohan@1324");
			assertEquals(true,isValid);
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void FirstNameInCorrect() {
		try {
			UserValidator.validate("Mohan$","Raj","mraj86698@gmail.com","91 9374930453","Mohan@1324");
		} catch (InvalidUserException e) {
			assertEquals(InvalidUserException.ExceptionType.INVALID_FIRST_NAME, e.type);
		}
	}

	@Test
	public void LastNameInCorrect() {
		try {
			UserValidator.validate("Mohan","Rj","mraj86698@gmail.com","91 9374930453","Mohan@1324");
		} catch (InvalidUserException e) {
			assertEquals(InvalidUserException.ExceptionType.INVALID_LAST_NAME, e.type);
		}
	}

	@Test
	public void EmailInvalid() {
		try {
			UserValidator.validate("Mohan","Raj","mraj86698@","91 9374930453","Mohan@1324");
		} catch (InvalidUserException e) {
			assertEquals(InvalidUserException.ExceptionType.INVALID_EMAIL, e.type);
		}
	}

	@Test
	public void MobileInvalid() {
		try {
			UserValidator.validate("Mohan","Raj","mraj86698@gmail.com","91 93749","Mohan@1324");
		} catch (InvalidUserException e) {
			assertEquals(InvalidUserException.ExceptionType.INVALID_MOBILE, e.type);
		}
	}

	@Test
	public void PasswordInvalid() {
		try {
			UserValidator.validate("Mohan","Raj","mraj86698@gmail.com","91 9374930453","Mohan");
		} catch (InvalidUserException e) {
			assertEquals(InvalidUserException.ExceptionType.INVALID_PASSWORD, e.type);
		}
	}
}
