package com.yieldstreet.challenge.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.yieldstreet.challenge.model.AccreditationProof;
import com.yieldstreet.challenge.model.Document;

@Service
public class UserAccreditationService {
	
	private final String[] ACCEPTED_MIME_TYPES = {"application/pdf","image/png","image/jpeg","image/jpg"};

	
	public boolean verify(AccreditationProof proof, String user) throws FileNotFoundException, IOException {
		if(proof.getDocuments() == null || proof.getDocuments().isEmpty())
			return false;
		
		for(Document doc: proof.getDocuments()) {
			checkMimeType(doc);
		}
		
		return Math.random() >= 0.5;
		
	}
	
	private void checkMimeType(Document doc) {
		
		if(doc.getMimeType() == null || doc.getMimeType().isEmpty() ||
				!Arrays.asList(ACCEPTED_MIME_TYPES).contains(doc.getMimeType()))
			throw new IllegalArgumentException("File extension not accepted. Accepted files include: pdf, jpg and png");
	}
	
	
}