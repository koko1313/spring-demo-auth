package com.example.springdeloauth.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemoauth.models.UserModel;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

	// private UserModel userRepo;
	
	public ApplicationUserDetailsService() {
		// this.userRepo = userRepo;
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/*
		UserModel user = userRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		*/
		
		// hardcored for the example
		UserModel user = new UserModel();
		user.setUsername(username);
		
		Set<String> userRoles = new HashSet<>();
		userRoles.add("ROLE_ADMIN");
		userRoles.add("ROLE_USER");
		user.setRoles(userRoles);
		// end of hardcored code
		
		Set<String> roles = user.getRoles();
		
		return new UserPrincipal(user, roles);
	}

}