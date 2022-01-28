package com.insurance.motor.greeting;

public class Greeting {

	private final long id;
	private final String content;
	
	private final String country;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
		this.country = "India";
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getCountry() {
		return country;
	}
}