package com.rafaelsm.desafio.messages;

public class ErrorMessages {
	
	// Client Messages
	public static final String CLIENT_NOT_FOUNT = "Cliente não encontrado";
	public static final String EMAIL_ALREADY_EXISTS = "Email já utilizado";
	public static final String CPF_ALREADY_EXISTS = "CPF já utilizado";
	public static final String UNKNOWN_ADDRESS = "Endereço desconhecido";
	
	// Pagination Messages
	public static final String PAGE_LESS_THAN_ZERO = "parâmetro page não pode ser menor que 0 (zero)";
	public static final String SIZE_LESS_THAN_ONE = "parâmetro size não pode ser menor que 1 (one)";
	public static final String SIZE_BIGGER_THAN_100 = "parâmetro size não pode ser maior que 100";
	
	// Request and Messages
	public static final String MALFORMED_JSON = "JSON malformatado";
	
	// Validation Messages
	public static final String VALIDATION_ERROR = "Erro de validação";
	
}
