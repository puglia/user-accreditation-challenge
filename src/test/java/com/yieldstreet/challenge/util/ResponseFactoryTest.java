package com.yieldstreet.challenge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ResponseFactoryTest {
	
	private String payload = "ResponseFactoryTest.payload";


	@Test
	void generateSuccess() {
		ResponseEntity<Object> response = ResponseFactory.ok(payload);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(payload, response.getBody());
	}

	@Test
	void generateBadRequest() {
		ResponseEntity<Object> response = ResponseFactory.badRequest(payload);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		Assertions.assertEquals(payload, response.getBody());
	}
	
	@Test
	void generateNotFound() {
		ResponseEntity<Object> response = ResponseFactory.notFound(payload);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		Assertions.assertEquals(payload, response.getBody());
	}
	
	@Test
	void generateServerError() {
		ResponseEntity<Object> response = ResponseFactory.serverError(payload);
		Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		Assertions.assertEquals(payload, response.getBody());
	}
	
}
