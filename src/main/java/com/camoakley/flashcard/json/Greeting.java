package com.camoakley.flashcard.json;

public class Greeting {
	private String message;
	
	// CONSTRUCTOR
	public Greeting(String message){
		this.message = message;
	}
	
	// CLASS METHODS
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public String toString() {
		return "Greeting{" +
				"message='" + this.message + '\'' +
				'}';
	}
}
