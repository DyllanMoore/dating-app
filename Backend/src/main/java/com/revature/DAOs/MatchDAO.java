package com.revature.DAOs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Match;

@Repository
public interface MatchDAO extends JpaRepository<Match,Integer>{
	public Optional<Match> findByUser1AndUser2(int user1, int user2);
	
}
