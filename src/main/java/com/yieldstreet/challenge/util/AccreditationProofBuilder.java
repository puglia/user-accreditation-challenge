package com.yieldstreet.challenge.util;

import java.util.ArrayList;
import java.util.List;

import com.yieldstreet.challenge.model.AccreditationProof;
import com.yieldstreet.challenge.model.AccreditationType;
import com.yieldstreet.challenge.model.Document;

public class AccreditationProofBuilder {
	private AccreditationType accreditationType;
	private List<Document> documents = new ArrayList<>();

	public AccreditationType getAccreditationType() {
		return accreditationType;
	}

	public AccreditationProofBuilder setAccreditationType(AccreditationType accreditationType) {
		this.accreditationType = accreditationType;
		return this;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public AccreditationProofBuilder setDocuments(List<Document> documents) {
		this.documents = documents;
		return this;
	}
	
	public AccreditationProofBuilder addDocument(Document document) {
		this.documents.add(document);
		return this;
	}
	
	public AccreditationProof build() {
		AccreditationProof proof = new AccreditationProof();
		proof.setAccreditationType(this.accreditationType);
		proof.setDocuments(this.getDocuments());
		return proof;
	}

}
