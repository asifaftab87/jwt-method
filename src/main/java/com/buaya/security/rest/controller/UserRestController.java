package com.buaya.security.rest.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buaya.security.dto.UserDTO;
import com.buaya.security.model.Role;
import com.buaya.security.model.User;
import com.buaya.security.service.CustomUserDetailsService;
import com.buaya.security.service.impl.RoleService;
import com.buaya.security.service.impl.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/admin/add/user", method = RequestMethod.POST)
	public void add(@RequestBody User user, HttpServletRequest request) {
		customUserDetailsService.addUser(user, "USER");
	}
	
	
	/*
	 * This will return all users
	 */
	@GetMapping(value="/get/all")
	public List<UserDTO> findAllUser(Principal principal) {	
		
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();	
		
		for(User user : userService.getAllUser()) {
			UserDTO userDTO = dozerBeanMapper.map(user, UserDTO.class);
			userDTOList.add(userDTO);
		}
		
		return userDTOList;	
	}
	
	/*
	 * This will return all users except login user
	 */
	@GetMapping(value="/get/all/except/login")
	public List<UserDTO> findAllUsersExceptGivenEmail(Principal principal) {	
		
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();	
		
		for(User user : userService.findAllUsersExceptGivenEmail(principal.getName())) {
			UserDTO userDTO = dozerBeanMapper.map(user, UserDTO.class);
			userDTOList.add(userDTO);
		}
		
		return userDTOList;	
	}
	
	/*
	 * To update user role we have to pass user emailid and rolename
	 * this rolename should be the 
	 */
	@GetMapping(value = "/update/role/email/{email}/roleName/{roleName}")
	public UserDTO updateRole(@PathVariable String email, @PathVariable String roleName) {
		
		User user = userService.findByEmail(email);
		Role role = roleService.findByRole(roleName);
		
		user.setRoles(new HashSet<>(Arrays.asList(role)));
		userService.update(user);
		
		UserDTO userDTO = dozerBeanMapper.map(user, UserDTO.class);
		return userDTO;
	}

	/*
	 * To update user role we have to pass user userid and rolename
	 * this rolename should be the 
	 */
	@GetMapping(value = "/update/role/id/{id}/roleName/{roleName}")
	public UserDTO updateRoleById(@PathVariable int id, @PathVariable String roleName) {
		
		User user = userService.findById(id);
		Role role = roleService.findByRole(roleName);
		
		user.setRoles(new HashSet<>(Arrays.asList(role)));
		userService.update(user);
		
		UserDTO userDTO = dozerBeanMapper.map(user, UserDTO.class);
		return userDTO;
	}
	
}
















