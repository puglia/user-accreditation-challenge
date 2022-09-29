package com.yieldstreet.challenge.exchange;

import java.util.Date;

public class ErrorResponse {

	private String message;
	private Date timestamp;
	private String errorType;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message, Date timestamp, String errorType) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.errorType = errorType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

}
