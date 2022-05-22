package com.nur.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRestController {
	
	@GetMapping("/home")
	public String welcome() {
		return "Welcome to Java World..";
	}
	
	@GetMapping("/balance")
	public String balance() {
		return "Your account balance is Rs. 3Cr.";
	}
	
	@GetMapping("/statement")
	public String ministatement() {
		return "Mini statement will display here:";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "Contact Details:";
	}

}
