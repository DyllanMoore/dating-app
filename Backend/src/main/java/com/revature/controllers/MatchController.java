package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	
}
