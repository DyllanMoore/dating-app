package com.revature.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
	
	//Get all users endpoint will be /data/users
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> allUsers = uDAO.findAll();
		for(Users user:allUsers) {
			user.setpfp(compressBytes(user.getpfp()));
			user.setPassword(null); //Setting returned passwords to null, presumably we don't want them sent
		}
		return ResponseEntity.ok(allUsers);
	}
	
	//GetByUsername endpoint will be /data/users/{username}
	@GetMapping("/{username}")
	public ResponseEntity<Users> getByUsername(@PathVariable("username") String username){
		Optional<Users> optionalUsers = uDAO.findByUsername(username);
		
		Users user;
		
		if(optionalUsers.isPresent()) {
			user = optionalUsers.get();
			user.setpfp(compressBytes(user.getpfp()));
			return ResponseEntity.ok().body(user);
		}
		
		return ResponseEntity.status(400).build();
	}
	
	//GetByState endpoint will be /data/users/{state}
	@GetMapping("/{state}")
	public ResponseEntity<Users> getByState(@PathVariable("state") String state){
		Optional<Users> optionalUsers = uDAO.findByState(state);
		
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

		user.setpfp(decompressBytes(user.getpfp()));
		Users newUser = uDAO.save(user);
		
		if(newUser == null) {
			return ResponseEntity.badRequest().build();
		}
		
		
		return ResponseEntity.accepted().body(newUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateUser(@PathVariable("id") Users user) {
		Optional<Users> optionalUsers = uDAO.findByUsername(user.getUsername());
		
		Users oldUsers;
		if(optionalUsers.isPresent()) {
			oldUsers = optionalUsers.get();
			user.setUser_id(oldUsers.getUser_id());
			user.setpfp(compressBytes(user.getpfp()));
			Users newUser = uDAO.save(user);
			return ResponseEntity.accepted().body(newUser);
		}
		return ResponseEntity.badRequest().build();
	}
	
	//Compresses byte data
	public static byte[] compressBytes(byte[] data) {
		//prevents trying to compress null values
		if(data == null) {
			return data;
		}
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while(!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer,0,count);
		}
		
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return outputStream.toByteArray();
	}
	
	//decompresses byte data
	public static byte[] decompressBytes(byte[] data) {
		//Prevents attempting to decompress null values
		if(data == null) {
			return data;
		}
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		
		try {
			while(!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer,0,count);
			}
			outputStream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (DataFormatException e) {
			e.printStackTrace();
		}
		
		return outputStream.toByteArray();
	}
	
	
}
