package com.yieldstreet.challenge.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.yieldstreet.challenge.exchange.UserAccreditationRequest;
import com.yieldstreet.challenge.model.AccreditationProof;
import com.yieldstreet.challenge.model.AccreditationType;
import com.yieldstreet.challenge.util.AccreditationProofBuilder;
import com.yieldstreet.challenge.util.DocumentBuilder;

class UserAccreditationServiceTest {

	@InjectMocks
	private UserAccreditationService userAccreditationService;

	private UserAccreditationRequest request;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		AccreditationProof proof = new AccreditationProofBuilder().setAccreditationType(AccreditationType.BY_INCOME)
				.addDocument(new DocumentBuilder().setName("2018.pdf").setMimeType("application/pdf")
						.setContent("ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==").build())
				.addDocument(new DocumentBuilder().setName("2019.pdf").setMimeType("image/jpeg")
						.setContent("91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgo=").build())
				.build();
		request = new UserAccreditationRequest();
		request.setUserId("g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V");
		request.setPayload(proof);
	}

	@Test
	public void checkValidInput() {
		Assertions.assertDoesNotThrow(() -> userAccreditationService.verify(request.getPayload(), request.getUserId()));
	}

	@Test
	public void checkInvalidMimeType() {
		request.getPayload().getDocuments().add(
				new DocumentBuilder().setName("2017.json").setMimeType("application/json").setContent("{}").build());
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> userAccreditationService.verify(request.getPayload(), request.getUserId()));
	}
	
	@Test
	public void checkEmptyUser() {
		request.setUserId(null);
		Boolean accredited = Assertions.assertDoesNotThrow(() -> userAccreditationService.verify(request.getPayload(), request.getUserId()));
		Assertions.assertFalse(accredited);
	}
	
}
