package com.buaya.security.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.buaya.security.model.CustomUserDetails;
import com.buaya.security.model.Role;
import com.buaya.security.model.User;
import com.buaya.security.repository.RoleRepository;
import com.buaya.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("email username: "+email);
		Optional<User> user = userRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+email));
		return user.map(CustomUserDetails::new).get();
	}
  
	public User saveUser(User user, Set<Role> role) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(role);
        return userRepository.save(user);
    }
	
	public User addUser(User user, String roleName) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setActive(true);
        Role role = roleRepository.findByRole(roleName);
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        return userRepository.save(user);
    }
	
	public User saveUser(User user, String roleName) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role role = roleRepository.findByRole(roleName);
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        return userRepository.save(user);
    }
	
	public User findByEmail(String email) {
		
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
}