package com.yieldstreet.challenge.model;

import java.util.List;

import org.springframework.lang.NonNull;

public class AccreditationProof {
	@NonNull
	private AccreditationType accreditationType;
	private List<Document> documents;

	public AccreditationType getAccreditationType() {
		return accreditationType;
	}

	public void setAccreditationType(AccreditationType accreditationType) {
		this.accreditationType = accreditationType;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String toString() {
		return  "accreditationType: " + this.accreditationType;
	}
}
