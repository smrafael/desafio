package com.rafaelsm.desafio.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	
	private Integer code;
	
	private HttpStatus status;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDateTime timestamp;
	
	private String message;
	
	private String debugMessage;
	
	private ApiError() {
		this.timestamp = LocalDateTime.now();
	}
	
	public ApiError(HttpStatus status) {
		this();
		this.code = status.value();
		this.status = status;
	}
	
	public ApiError(HttpStatus status, String message) {
		this(status);
		this.message = message;
	}
	
	ApiError(HttpStatus status, Throwable ex) {
		this(status);
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	ApiError(HttpStatus status, String message, Throwable ex) {
		this(status);
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	
}