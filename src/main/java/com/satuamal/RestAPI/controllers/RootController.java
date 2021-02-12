package com.satuamal.RestAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {

	@GetMapping
	public String welcome() {
		return "<h1>Welcome to satuamal API</h1>\n<p>please consult with the README file for endpoint reference</p>";
	}
}
