package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.DAOs.UsersDAO;
import com.revature.models.LoginDTO;
import com.revature.models.Users;

@RestController
@RequestMapping(value="/users")
public class UsersController {
	
	private UsersDAO uDAO;
	
	@Autowired
	public UsersController(UsersDAO uDAO) {
		super();
		this.uDAO = uDAO;
	}
	
	//Login endpoint will be /data/users/login
	@PostMapping(value="/login")
	public ResponseEntity<Users> login(@RequestBody LoginDTO lDTO){
		Optional<Users> optionalUsers = uDAO.findByUsernameAndPassword(lDTO.getUsername(), lDTO.getPassword());
		
		Users user;
		
		if(optionalUsers.isPresent()) {
			user = optionalUsers.get();
			return ResponseEntity.accepted().body(user);
		}
		
		return ResponseEntity.status(403).build();
	}
	
	//New user endpoint will be /data/users
	@PostMapping
	public ResponseEntity addUser(@RequestBody Users user) {
		Users newUser = uDAO.save(user);
		
		if(newUser == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body(newUser);
	}
	
	
}
