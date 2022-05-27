package com.nur.rest;

import org.springframework.web.bind.annotation.GetMapping;

//@RestController
public class SecurityRestController {
	
	@GetMapping("/home")
	public String home() {
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
	
	@GetMapping("/std")
	public String std() {
		return "Student Page:";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Admin Details:";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Admin Details:";
	}
	
	@GetMapping("/accessDenied")
	public String accessD() {
		return "Access Denied Page";
	}

}
