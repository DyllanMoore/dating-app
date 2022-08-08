package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserDAO;
import com.revature.models.User;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {

	private UserDAO uDAO;
	
	@Autowired
	public UserController(UserDAO uDAO) {
		super();
		this.uDAO = uDAO;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<User> login(@RequestBody User u){
		Optional<User> optionalUser = uDAO.findByUsernameAndPassword(u.getUsername(), u.getPassword());
		User user;
		if(optionalUser.isPresent()) {
			user = optionalUser.get();
			return ResponseEntity.accepted().body(user);
		}
		return ResponseEntity.status(403).build();
	}
	
}
