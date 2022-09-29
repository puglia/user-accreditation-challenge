package com.yieldstreet.challenge.controller;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yieldstreet.challenge.model.UserAccreditationRequest;
import com.yieldstreet.challenge.model.UserAccreditationResponse;
import com.yieldstreet.challenge.service.UserAccreditationService;
import static com.yieldstreet.home.challenge.util.ResponseFactory.ok;

@RestController
@RequestMapping("/user")
public class UserAccreditationController {

	@Autowired
	UserAccreditationService userAccreditationService;

	@PostMapping("/accreditation")
	public ResponseEntity<Object> validate(@RequestBody UserAccreditationRequest req) throws FileNotFoundException, IOException {
		
		boolean accredited= userAccreditationService.verify(req.getPayload(), req.getUserId());
		
		return ok(new UserAccreditationResponse(accredited,true));
	}
}
