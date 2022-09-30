package com.yieldstreet.challenge.controller;


import static com.yieldstreet.challenge.util.ResponseFactory.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yieldstreet.challenge.exchange.UserAccreditationRequest;
import com.yieldstreet.challenge.exchange.UserAccreditationResponse;
import com.yieldstreet.challenge.service.UserAccreditationService;

@RestController
@RequestMapping("/user")
public class UserAccreditationController {

	@Autowired
	UserAccreditationService userAccreditationService;

	@PostMapping("/accreditation")
	public ResponseEntity<Object> validate(@RequestBody UserAccreditationRequest req) {
		
		boolean accredited= userAccreditationService.verify(req.getPayload(), req.getUserId());
		
		return ok(new UserAccreditationResponse(true,accredited));
	}
}
