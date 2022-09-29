package com.yieldstreet.challenge.model;

import org.springframework.lang.NonNull;

public class UserAccreditationRequest {
	@NonNull
	private String userId;
	private AccreditationProof payload;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public AccreditationProof getPayload() {
		return payload;
	}

	public void setPayload(AccreditationProof payload) {
		this.payload = payload;
	}
}
