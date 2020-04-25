package com.buaya.security.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buaya.security.model.User;
import com.buaya.security.service.CustomUserDetailsService;

@RestController
public class LoginController {

	@Autowired
	private CustomUserDetailsService userService;
	
	@PostMapping(value = "/registration")
	public User registerPost(@RequestBody User user, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user2 = userService.findByEmail(user.getEmail());
		
		if(user2!=null) {
			throw new Exception(user.getEmail() + "User already exists");
		}
		
		user2 = userService.addUser(user, "ROLE_USER");
        return user2;
	}
}
