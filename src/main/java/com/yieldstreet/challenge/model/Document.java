package com.yieldstreet.challenge.model;

public class Document {
	private String name;
	private String mimeType;
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		return "name: " + this.name + ", mimeType: " + this.mimeType + ", content: " + this.content;
	}

}
