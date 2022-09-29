package com.yieldstreet.home.challenge.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
	
	public static ResponseEntity<Object> serverError(Object entity) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(entity);
	}
	
	public static ResponseEntity<Object> notFound(Object entity) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entity);
	}
	
	public static ResponseEntity<Object> badRequest(Object entity) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entity);
	}
	
	public static ResponseEntity<Object> ok(Object entity) {
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}


}
