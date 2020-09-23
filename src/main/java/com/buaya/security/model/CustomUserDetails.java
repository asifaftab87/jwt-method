package com.buaya.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 4470072355315571719L;
	
	private final transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	private String userName;
	private String password;
	private boolean active;
//	private List<GrantedAuthority> authorities;
	private List<GrantedAuthority> gAuth = new ArrayList<>();
	
	public CustomUserDetails() {}
	
	public CustomUserDetails(User user) {
		
		this.userName = user.getEmail();
		this.password = user.getPassword();
		this.active = user.getActive();
		
		//this.authorities = user.getRoles().stream().map(Role::getRole).map(String::valueOf).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		user.getRoles().forEach(role ->
		{
			gAuth.add(new SimpleGrantedAuthority(role.getRole()));
		});
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//return authorities;
		 
		
		return gAuth;
	
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
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
		return active;
	}
}
