package com.buaya.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buaya.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findByRole(String role);

}
