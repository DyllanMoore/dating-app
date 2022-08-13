package com.revature.controllers;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.DAOs.UsersDAO;
import com.revature.models.LoginDTO;
import com.revature.models.Users;

@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins = "http://localhost:4200")
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
	
	//GetByUsername endpoint will be /data/users/{username}
	@GetMapping("/{username}")
	public ResponseEntity<Users> getByUsername(@PathVariable("username") String username){
		Optional<Users> optionalUsers = uDAO.findByUsername(username);
		
		Users user;
		
		if(optionalUsers.isPresent()) {
			user = optionalUsers.get();
			return ResponseEntity.ok().body(user);
		}
		
		return ResponseEntity.status(400).build();
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
	
	@PutMapping
	public ResponseEntity updateUser(@RequestBody Users user) {
		Optional<Users> optionalUsers = uDAO.findByUsername(user.getUsername());
		
		Users oldUsers;
		if(optionalUsers.isPresent()) {
			oldUsers = optionalUsers.get();
			user.setUser_id(oldUsers.getUser_id());
			Users newUser = uDAO.save(user);
			return ResponseEntity.accepted().body(newUser);
		}
		return ResponseEntity.badRequest().build();
	}
	
}
