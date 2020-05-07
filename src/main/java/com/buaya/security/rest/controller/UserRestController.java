package com.buaya.security.rest.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buaya.security.dto.HandicapDTO;
import com.buaya.security.dto.UserDTO;
import com.buaya.security.model.Handicap;
import com.buaya.security.model.Role;
import com.buaya.security.model.User;
import com.buaya.security.service.impl.HandicapService;
import com.buaya.security.service.impl.RoleService;
import com.buaya.security.service.impl.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HandicapService handicapService;
	
	Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	@PostMapping(value = "/admin/add/user")
	public void add(@RequestBody UserDTO userDTO, HttpServletRequest request) {
		
		userService.addUser(userDTO, "USER");
	}
	
	
	@PostMapping(value = "/admin/edit/user/id/{userId}")
	public UserDTO edit(@PathVariable int userId, @RequestBody UserDTO userDTO, HttpServletRequest request) {
		
		log.info("edit user {}", userDTO);
		User user = userService.editUser(userDTO, "USER");
		userDTO = dozerBeanMapper.map(user, UserDTO.class);
		HandicapDTO handicapDTO = dozerBeanMapper.map(user.getHandicap(), HandicapDTO.class);
		userDTO.setHandicapDTO(handicapDTO);
		return userDTO;
	}
	
	/*
	 * Please don't use this service 
	 * if u require inform me I will create new one
	 */
	@PostMapping(value = "/admin/add/player")
	public UserDTO addPlayer(@RequestBody UserDTO userDTO, HttpServletRequest request) {
		
		HandicapDTO handicapDTO = userDTO.getHandicapDTO();
		
		User user = dozerBeanMapper.map(userDTO, User.class);
		user.setPassword(userDTO.getPasswordGame());

		userDTO = dozerBeanMapper.map(user, UserDTO.class);
		
		handicapDTO.setUserId(user.getId());
		handicapDTO = handicapService.add(handicapDTO);
		
		if(handicapDTO!=null) {
			userDTO.setHandicapDTO(handicapDTO);
		}
		
		return userDTO;
	}
	
	
	/*
	 * This will return all users
	 */
	@GetMapping(value="/get/all")
	public List<UserDTO> findAllUser(Principal principal) {	
		
		List<UserDTO> userDTOList = new ArrayList<>();	
		
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
		
		List<UserDTO> userDTOList = new ArrayList<>();	
		
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
		
		return dozerBeanMapper.map(user, UserDTO.class);
	}

	/*
	 * To update user role we have to pass user userid and rolename
	 * this rolename should be the 
	 */
	@GetMapping(value = "/update/role/id/{id}/roleName/{roleName}")
	public UserDTO updateRoleById(@PathVariable int id, @PathVariable String roleName) {
		
		User user = userService.updateRoleById(id, roleName);
		
		return dozerBeanMapper.map(user, UserDTO.class);
		
	}
	
	/*
	 * Get user by user id
	 */
	@GetMapping(value = "/find/id/{id}")
	public UserDTO findUserById(@PathVariable int id) {
		
		User user = userService.findById(id);
		UserDTO userDTO = dozerBeanMapper.map(user, UserDTO.class);
		userDTO.setFullName(user.getFirstName()+" "+user.getLastName());
		
		Handicap handicap = user.getHandicap();
		
		if(handicap!=null) {
			userDTO.setHandicapDTO(dozerBeanMapper.map(handicap, HandicapDTO.class));
		}
		
		return userDTO;
	}
	
	
}
















