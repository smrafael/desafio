package com.rafaelsm.desafio.messages;

public class ErrorMessages {
	
	// Client Messages
	public static final String CLIENT_NOT_FOUNT = "client not found";
	public static final String EMAIL_ALREADY_EXISTS = "email already exists";
	public static final String CPF_ALREADY_EXISTS = "cpf already exists";
	
	// Pagination Messages
	public static final String PAGE_LESS_THAN_ZERO = "page can not be less than 0 (zero)";
	public static final String SIZE_LESS_THAN_ZERO = "size can not be less than 0 (zero)";
	public static final String SIZE_BIGGER_THAN_100 = "size can not be bigger than 100";
	
	// Request and Messages
	public static final String MALFORMED_JSON = "malformed JSON request";
	
	// Validation Messages
	public static final String VALIDATION_ERROR = "validation error";
	
}
