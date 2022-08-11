package com.revature.DAOs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer>{

	public Optional<Users> findByUsernameAndPassword(String username, String password);

	public Optional<Users> findByUsername(String username);
	
	
}
