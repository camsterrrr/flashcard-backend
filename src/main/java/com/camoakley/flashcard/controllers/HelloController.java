package com.camoakley.flashcard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HelloController {
	
	@GetMapping("/hello") // http://localhost:8080/hello?name=cam
	public String sayHello(
			@RequestParam(value = "name", required = false, 
			defaultValue = "World") String name, Model model) {
		
		model.addAttribute("user", name);
		
		return "hello"; // look for hello.html in src/main/resources/templates
	}
}
