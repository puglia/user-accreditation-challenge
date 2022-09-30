package com.yieldstreet.challenge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.yieldstreet.challenge.model.AccreditationProof;
import com.yieldstreet.challenge.model.AccreditationType;

class AccreditationProofBuilderTest {

	@Test
	public void generateDocument() {
		String name = "2019.pdf";
		String mimeType = "application/pdf";
		String content = "xxxxxxxx";
		AccreditationType type = AccreditationType.NETWORTH;
		AccreditationProof proof = new AccreditationProofBuilder().setAccreditationType(type)
			.addDocument(new DocumentBuilder().setContent(content)
							.setName(name)
							.setMimeType(mimeType)
							.build())
				.build();
		Assertions.assertEquals(type, proof.getAccreditationType());
		Assertions.assertEquals(1, proof.getDocuments().size());
	}
	
}
