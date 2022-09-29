package com.yieldstreet.challenge.aspect;

import static com.yieldstreet.challenge.util.ResponseFactory.*;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yieldstreet.challenge.exchange.ErrorResponse;

@RestControllerAdvice
public class ErrorHandlingAdvice extends ResponseEntityExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static final String BAD_REQUEST = "Bad Request";
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleBadRequest(Exception ex) {
		logger.error(ex.getMessage(),ex);
		ErrorResponse response = new ErrorResponse(ex.getMessage(),new Date(),BAD_REQUEST);
		return badRequest(response);
	}
	
	@ExceptionHandler(value = { Throwable.class })
	protected ResponseEntity<Object> handleInternalError(Throwable ex) {
		logger.error(ex.getMessage(),ex);
		ErrorResponse response = new ErrorResponse(ex.getMessage(),new Date(),INTERNAL_SERVER_ERROR);
		return badRequest(response);
	}
}
