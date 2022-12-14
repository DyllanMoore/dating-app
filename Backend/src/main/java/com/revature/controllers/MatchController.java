package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Match;
import com.revature.models.MatchDTO;
import com.revature.services.MatchService;

@RestController
@RequestMapping(value="/match")
@CrossOrigin
public class MatchController {
	
	private MatchService mService;
	
	@Autowired
	public MatchController(MatchService mService) {
		super();
		this.mService = mService;
	}
	
	//add match endpoint will be /data/match
	@PostMapping
	public ResponseEntity addMatch(@RequestBody MatchDTO mDTO) {
		Match newMatch = mService.addMatch(mDTO.getUser1(), mDTO.getUser2());
		
		if(newMatch == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body(newMatch);
	}
	
	@GetMapping("/likedby/{id}")
	public ResponseEntity<List<Match>> getLikedBy(@PathVariable("id") int id) {
		List<Match> matchList = mService.getLikedBy(id);
		return ResponseEntity.ok(matchList);
	}
	
	@GetMapping("/liked/{id}")
	public ResponseEntity<List<Match>> getLiked(@PathVariable("id") int id) {
		List<Match> matchList = mService.getLiked(id);
		return ResponseEntity.ok(matchList);
	}
	
	//Method for getting a user's mutual matches, place holder
	@GetMapping("{id}")
	public ResponseEntity<List<Match>> getMatches(@PathVariable("id") int id){
		List<Match> matchList = mService.getMatches(id);
		return null;
	}

	
	
}
