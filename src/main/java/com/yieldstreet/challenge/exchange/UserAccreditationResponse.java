package com.yieldstreet.challenge.exchange;

public class UserAccreditationResponse {

	private boolean success;
	private boolean accredited;
	
	public UserAccreditationResponse() {
		super();
	}

	public UserAccreditationResponse(boolean success, boolean accredited) {
		super();
		this.success = success;
		this.accredited = accredited;
	}

	public boolean isAccredited() {
		return accredited;
	}

	public void setAccredited(boolean accredited) {
		this.accredited = accredited;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
