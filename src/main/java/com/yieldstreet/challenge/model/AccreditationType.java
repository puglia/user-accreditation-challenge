package com.yieldstreet.challenge.model;

public enum AccreditationType {
	
	BY_INCOME("by_income",1),
	NETWORTH("networth",2),
	CERTIFICATION("professional_certification",3),
	OTHER("other",0);
	
	private String name;
	private int code;
	
	AccreditationType(String name,int code){
		this.name = name;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}

}
