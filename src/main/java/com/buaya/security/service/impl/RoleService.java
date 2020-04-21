package com.buaya.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buaya.security.model.Role;
import com.buaya.security.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role findByRole(String roleName) {
		return roleRepository.findByRole(roleName);
	}
}
