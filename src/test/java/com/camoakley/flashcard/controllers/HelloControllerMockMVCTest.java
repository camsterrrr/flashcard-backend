package com.camoakley.flashcard.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
public class HelloControllerMockMVCTest {	
	// Actual unit tests using Mockito
	@Autowired
	private MockMvc mvc;
	
	// Optional test, check that Autowired dependency injection worked.
	@Test
	void autowiringWorked() {
		assertNotNull(mvc);
	}
	
	@Test
	public void testHelloWithoutName() throws Exception {
		mvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
			.andExpect(status().isOk())			// we should receive HTTP 200 message
			.andExpect(view().name("hello"))	// view should be named 'hello'
			.andExpect(model().attribute("user", "World")); 
				// the attribute named 'user' should have a value of "World"
	}
	
	@Test
	public void testHelloWithName() throws Exception {
		mvc.perform(get("/hello").param("name", "cam").accept(MediaType.TEXT_HTML))
			.andExpect(status().isOk())
			.andExpect(view().name("hello"))
			.andExpect(model().attribute("user", "cam"));
	}
}
