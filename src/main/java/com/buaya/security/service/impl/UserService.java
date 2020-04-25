package com.buaya.security.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buaya.security.model.User;
import com.buaya.security.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

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
	
	public User findById(int id) {
		
		Optional<User> optional = userRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
}
