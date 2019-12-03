package com.example.springdeloauth.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springdemoauth.models.UserModel;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private UserModel user;
	private Set<GrantedAuthority> authorities;
	
	public UserPrincipal(UserModel user, Set<String> roles) {
		this.user = user;
		authorities = new HashSet<GrantedAuthority>();

		for(String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		if(authorities.isEmpty()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}