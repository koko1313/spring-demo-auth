package com.example.springdemoauth.rest;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemoauth.models.UserModel;

@RestController
public class LoginController {

	private UserDetailsService userDetailsService;
	// private UserRepository userRepo;
	
	public LoginController(UserDetailsService userDetailsService /* , UserRepository userRepo */) {
		this.userDetailsService = userDetailsService;
		// this.userRepo = userRepo;
	}
	
	// have to be with PostMapping
	@GetMapping(path = "/login")
	public boolean login(
			@RequestParam(value = "username") String username, 
			@RequestParam(value = "password") String password) {
		
		// UserModel user = userRepo.findUserByUsernameAndPassword(username, password);
		
		// hardcored
		UserModel user = new UserModel();
		user.setUsername(username);
		// end of hardcored
		
		if(user != null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
			
			if(userDetails != null) {
				Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
			return true;
		}
			
		return false;
	}
	
	// have to be with PostMapping
	@GetMapping(path = "/logout-user")
	public boolean logout(HttpSession session) {
		session.invalidate();
		
		return true;
	}

}


