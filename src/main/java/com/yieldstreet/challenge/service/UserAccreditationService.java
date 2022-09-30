package com.yieldstreet.challenge.service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.yieldstreet.challenge.model.AccreditationProof;
import com.yieldstreet.challenge.model.Document;

@Service
public class UserAccreditationService {
	
	protected static final String[] ACCEPTED_MIME_TYPES = {"application/pdf","image/png","image/jpeg","image/jpg"};

	
	public boolean verify(AccreditationProof proof, String user) {
		if(proof.getDocuments() == null || proof.getDocuments().isEmpty()
				|| "".equals(user) || user == null )
			return false;
		
		for(Document doc: proof.getDocuments()) {
			checkMimeType(doc);
			checkContent(doc.getContent());
		}
		SecureRandom random = new SecureRandom(); 
		
		return random.nextInt()% 2 == 0;
		
	}
	
	private void checkMimeType(Document doc) {
		
		if(doc.getMimeType() == null || doc.getMimeType().isEmpty() ||
				!Arrays.asList(ACCEPTED_MIME_TYPES).contains(doc.getMimeType()))
			throw new IllegalArgumentException("File extension not accepted. Accepted files include: pdf, jpg and png");
	}
	
	private void checkContent(String content) {
		Base64.getDecoder().decode(content);
	}
	
	
}