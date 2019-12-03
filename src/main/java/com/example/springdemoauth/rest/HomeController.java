package com.example.springdemoauth.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String everyone() {
		return "You can reach this page because you are not authenticated!";
	}
	
	@GetMapping("/admin")
	@Secured("ROLE_ADMIN")
	public String admin(Authentication authentication) {
		return "Hey! You see this page because you have role admin. Your username is " + authentication.getName();
	}
	
	@GetMapping("/user")
	@Secured("ROLE_USER")
	public String user() {
		return "Heyyy you user!";
	}
	
}
