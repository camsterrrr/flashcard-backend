package com.camoakley.flashcard.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private ApplicationContext appContext;
	
	@Test
	void appContextLoads() {
		assertNotNull(appContext);
		System.out.println("Output:\t" + appContext.getClass().getName());
	}
}
