package com.buaya.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buaya.security.request.model.AuthenticationRequest;
import com.buaya.security.response.model.AuthenticationResponse;
import com.buaya.security.service.CustomUserDetailsService;
import com.buaya.security.util.JwtUtil;

//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://buaya.skali.my")
@RestController
public class HelloResource {

	private final Logger log = LoggerFactory.getLogger(HelloResource.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping({"/hello"})
	public String hello() {
		log.info("---------------------------------------------------   hello  -----------------------------------------------");
		return "Hello World";
	}
	
	/*
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequestModel req) throws Exception {
		
		log.info("createAuthenticationToken");
		
		log.info("email: "+req.getEmail());
		
		User user = userDetailsService.findByEmail(req.getEmail());
		log.info("user: "+user);
		
		if(user==null) {
			throw new Exception("User not found");
		}
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword(), 
					user.getRoles().stream().map(role->role.getRole()).map(String::valueOf).map(SimpleGrantedAuthority::new).collect(Collectors.toList())));
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	*/
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest req) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
}
