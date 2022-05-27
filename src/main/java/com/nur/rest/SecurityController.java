package com.nur.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/student")
	public String std() {
		return "student";
	}
	
	@GetMapping("/user")
	public String users() {
		return "user";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/accessDenied")
	public String accessD() {
		return "accessDenied";
	}

}
