package com.yieldstreet.challenge.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.yieldstreet.challenge.exchange.UserAccreditationRequest;
import com.yieldstreet.challenge.exchange.UserAccreditationResponse;
import com.yieldstreet.challenge.model.AccreditationProof;
import com.yieldstreet.challenge.model.AccreditationType;
import com.yieldstreet.challenge.service.UserAccreditationService;
import com.yieldstreet.challenge.util.AccreditationProofBuilder;
import com.yieldstreet.challenge.util.DocumentBuilder;

class UserAccreditationControllerTest {
	
	@Mock
	private UserAccreditationService userAccreditationService;
	
	@InjectMocks
	private UserAccreditationController controller;
	
	private UserAccreditationRequest request;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		AccreditationProof proof= new AccreditationProofBuilder()
			.setAccreditationType(AccreditationType.BY_INCOME)
			.addDocument(new DocumentBuilder().setName("2018.pdf")
										.setMimeType("application/pdf")
										.setContent("ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==")
										.build())
			.addDocument(new DocumentBuilder().setName("2019.pdf")
										.setMimeType("image/jpeg")
										.setContent("91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgo=")
										.build())
			.build();
		request = new UserAccreditationRequest();
		request.setUserId("g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V");
		request.setPayload(proof);
	}

	@Test
	void checkValidInput() {
		
		when(userAccreditationService.verify(request.getPayload(),request.getUserId()))
			.thenReturn(true);
		ResponseEntity<Object> response = controller.validate(request);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertTrue(response.getBody() instanceof UserAccreditationResponse);
		Assertions.assertTrue(((UserAccreditationResponse) response.getBody()).isSuccess());
		Assertions.assertTrue(((UserAccreditationResponse) response.getBody()).isAccredited());
	}
	
	@Test
	void checkInvalidInput() {
		request.getPayload().getDocuments().add(new DocumentBuilder()
											.setName("2017.json")
											.setMimeType("application/json")
											.setContent("{}")
											.build());
		when(userAccreditationService.verify(request.getPayload(),request.getUserId()))
			.thenThrow(new IllegalArgumentException());
		Assertions.assertThrows(IllegalArgumentException.class, () -> controller.validate(request));
	}


}
