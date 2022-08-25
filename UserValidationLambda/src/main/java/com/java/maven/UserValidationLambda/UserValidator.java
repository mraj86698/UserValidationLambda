package com.java.maven.UserValidationLambda;

import java.util.Scanner;

import com.java.maven.UserValidationLambda.InvalidUserException.ExceptionType;

/**
 * User Details validate using lambda function to validate User Entry
 * @author mraj
 *
 */

public class UserValidator
{
	final static String NAME_PATTERN = "^[A-Z]{1}[a-zA-Z]{2,}";
	/**
	 * Acceptable email prefix formats
	 * letters (a-z), numbers, underscores, periods, and dashes.
	 * An underscore, period, or dash must be followed by one or more letter or number
	 * Acceptable email domain formats
	 * Allowed characters: letters, numbers, dashes.
	 * The last portion of the domain must be at least two characters, for example: .com, .org, .cc
	 */
	final static String EMAIL_PATTERN = "^[a-zA-Z0-9+_-]+([.][a-zA-Z0-9]+)*@([a-zA-Z0-9]+)([.][a-z]+)?[.][a-z]{2,}$";
	final static String MOBILE_PATTERN = "[0-9-]{1,}[ ][1-9]{1}[0-9]{9}";
	/**
	 * (?=.*[\\d])	The string must contain at least 1 numeric character
	 * (?=.*[a-z])	The string must contain at least 1 lowercase alphabetical character
	 * (?=.*[A-Z])	The string must contain at least 1 uppercase alphabetical character
	 * (?=.*[!@#$%^&*])	The string must contain at least one special character
	 * (?=.{8,})	The string must be eight characters or longer
	 */
	final static String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$";

	/**
	 * Validating the User Entries
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param mobile
	 * @param password
	 * @throws InvalidUserException
	 * @return true if all details are valid
	 */
	public static boolean validate(String firstName,String lastName,String email,String mobile,String password) throws InvalidUserException {

		UserEntryValidator validateFirstName = (firstNameValid) -> firstNameValid.matches(NAME_PATTERN);
		UserEntryValidator validateLastName = (lastNameValid) -> lastNameValid.matches(NAME_PATTERN);
		UserEntryValidator validateEmail = (emailValid) -> emailValid.matches(EMAIL_PATTERN);
		UserEntryValidator validateMobile = (mobileValid) -> mobileValid.matches(MOBILE_PATTERN);
		UserEntryValidator validatePassword = (passwordValid) -> passwordValid.matches(PASSWORD_PATTERN);
		/**
		 * Validate First Name
		 */
		boolean isFirstNameValid = validateFirstName.validate(firstName);
		if (isFirstNameValid)
			System.out.println("Valid first name");
		else
			throw new InvalidUserException(ExceptionType.INVALID_FIRST_NAME, "Please enter proper first name");
		/**
		 * Validate Last Name
		 */
		boolean isLastNameValid = validateLastName.validate(lastName);
		if (isLastNameValid)
			System.out.println("Valid last name");
		else
			throw new InvalidUserException(ExceptionType.INVALID_LAST_NAME, "Please enter proper last name");
		/**
		 * Validate EmailId
		 */
		boolean isEmailValid = validateEmail.validate(email);
		if (isEmailValid)
			System.out.println("Valid Email ID");
		else
			throw new InvalidUserException(ExceptionType.INVALID_EMAIL, "Please enter proper Email ID");
		/**
		 * Validate MobileNumber
		 */
		boolean isMobileValid = validateMobile.validate(mobile);
		if (isMobileValid)
			System.out.println("Valid Mobile Number");
		else
			throw new InvalidUserException(ExceptionType.INVALID_MOBILE, "Please enter proper mobile number");

		boolean isPasswordValid = validatePassword.validate(password);
		/**
		 * Validate Password
		 */
		if (isPasswordValid)
			System.out.println("Valid Password");
		else
			throw new InvalidUserException(ExceptionType.INVALID_PASSWORD, "Please enter proper password");

		return true;
	}

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to user registration");
		boolean isValid = false;
		Scanner sc = new Scanner(System.in);

		while(isValid==false) {
			try {
				System.out.println("Please enter your first name:");
				String firstName = sc.nextLine();
				System.out.println("Please enter your last name:");
				String lastName = sc.nextLine();
				System.out.println("Enter Email ID");
				String email = sc.nextLine();
				System.out.println("Enter Mobile number");
				String mobile = sc.nextLine();
				System.out.println("Enter password");
				String password = sc.nextLine();
				isValid = validate(firstName,lastName,email,mobile,password);
				System.out.println("User Details are Valid.");
			} catch (InvalidUserException e) {
				System.out.println(e.getMessage());
				System.out.println("\nEnter your details again");
			}
		}
	}
}
