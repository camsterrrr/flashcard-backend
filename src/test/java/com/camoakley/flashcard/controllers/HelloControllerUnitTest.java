package com.camoakley.flashcard.controllers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class HelloControllerUnitTest {
	// Unit test, but brute forced
	@Test // single test 
	public void sayHello() {
		HelloController controller = new HelloController();
		Model model = new BindingAwareModelMap();
		String result = controller.sayHello("World", model);
		assertAll(
				() -> assertEquals("World", model.getAttribute("user")),
				() -> assertEquals("hello", result)
		);
	}
}
