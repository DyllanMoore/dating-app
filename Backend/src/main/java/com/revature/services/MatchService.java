package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAOs.MatchDAO;
import com.revature.models.Match;

@Service
public class MatchService {
	private MatchDAO mDAO;
	
	@Autowired
	public MatchService(MatchDAO mDAO) {
		super();
		this.mDAO = mDAO;
	}
	
	//Business logic for adding a match, must check if it already exists and whether or not it is mutual yet
	public Match addMatch(int user1, int user2) {
		Optional<Match> optionalMatch = mDAO.findByUser1AndUser2(user1, user2);
		
		if(optionalMatch.isPresent()) {
			Match updatedMatch = optionalMatch.get();
			if(!updatedMatch.isMutual()) {
				//If the already existing match is not yet mutual, make it mutual and return.
				updatedMatch.setMutual(true);
				return mDAO.save(updatedMatch);
			}
			else {
				//Returning already mutual match, may require additional handing for front end
				return updatedMatch;
			}
			
		}
		else {
			
			//Check if match exists in reversed order (2,1)
			optionalMatch = mDAO.findByUser1AndUser2(user2, user1);
			
			if(optionalMatch.isPresent()) {
				Match updatedMatch = optionalMatch.get();
				if(!updatedMatch.isMutual()) {
					//If the already existing match is not yet mutual, make it mutual and return.
					updatedMatch.setMutual(true);
					return mDAO.save(updatedMatch);
				}
				else {
					//Returning already mutual match, may require additional handing for front end
					return updatedMatch;
				}
			}
			
			Match newMatch = new Match(user1, user2, false);
			return mDAO.save(newMatch);
			
		}
	}

	public List<Match> getLikedBy(int id) {
		Optional<List<Match>> optionalMatchList = mDAO.findByUser1(id);
		List<Match> matchList = optionalMatchList.get();
		return matchList;
	}
	
	public List<Match> getLiked(int id){
		Optional<List<Match>> optionalMatchList = mDAO.findByUser2(id);
		List<Match> matchList = optionalMatchList.get();
		return matchList;
	}
	
	
	
	

}
