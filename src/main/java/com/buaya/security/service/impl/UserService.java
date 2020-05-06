package com.buaya.security.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.buaya.security.model.Handicap;
import com.buaya.security.model.Role;
import com.buaya.security.model.User;
import com.buaya.security.repository.RoleRepository;
import com.buaya.security.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private HandicapService handicapService;
	
	@Autowired
	private RoleService roleService;
	
	public User addUser(User user, String roleName) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role role = roleRepository.findByRole(roleName);
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        return userRepository.save(user);
    }
	
	public User update(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User findByEmail(String email) {
		
		Optional<User> user = userRepository.findByEmail(email);
		
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public Collection<User> findAllUsersExceptGivenEmail(String email){
		return userRepository.findAllUsersExceptGivenEmail(email);
	}
	
	
	public User updateRoleById(int id, String roleName) {
		
		Optional<User> optional = userRepository.findById(id);
		
		if(optional.isPresent()) {
			
			User user = optional.get();
			
			Role role = roleService.findByRole(roleName);
			
			user.setRoles(new HashSet<>(Arrays.asList(role)));
			
			update(user);
			
			return user;
		}
		
		return null;
	}
	
	public User findById(int id) {
		
		Optional<User> optional = userRepository.findById(id);
		
		if(optional.isPresent()) {
			
			User user = optional.get();
			
			Handicap handicap = handicapService.findByUserId(user.getId());
			
			user.setHandicap(handicap);
			
			return user;
		}
		
		return null;
	}
	
}
