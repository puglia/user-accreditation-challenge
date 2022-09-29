package com.yieldstreet.challenge.exchange;

import org.springframework.lang.NonNull;

import com.yieldstreet.challenge.model.AccreditationProof;

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
