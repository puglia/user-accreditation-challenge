package com.yieldstreet.challenge.util;

import org.springframework.lang.NonNull;

import com.yieldstreet.challenge.model.Document;

public class DocumentBuilder {
	@NonNull
	private String name;
	private String mimeType;
	@NonNull
	private String content;

	public String getName() {
		return name;
	}

	public DocumentBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public String getMimeType() {
		return mimeType;
	}

	public DocumentBuilder setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	public String getContent() {
		return content;
	}

	public DocumentBuilder setContent(String content) {
		this.content = content;
		return this;
	}
	
	public Document build() {
		Document document = new Document();
		document.setContent(content);
		document.setMimeType(mimeType);
		document.setName(name);
		return document;
	}

}
