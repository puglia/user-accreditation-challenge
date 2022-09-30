package com.yieldstreet.challenge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.yieldstreet.challenge.model.Document;

class DocumentBuilderTest {

	@Test
	void generateDocument() {
		String name = "2019.pdf";
		String mimeType = "application/pdf";
		String content = "xxxxxxxx";
		Document doc = new DocumentBuilder().setContent(content)
		.setName(name).setMimeType(mimeType).build();
		Assertions.assertEquals(name, doc.getName());
		Assertions.assertEquals(mimeType, doc.getMimeType());
		Assertions.assertEquals(content, doc.getContent());
	}
	
}
