package com.revature.models;

import org.springframework.stereotype.Component;

//DTO for receiving only the id's for a match
@Component
public class MatchDTO {
	
	private int user1;
	private int user2;
	
	public MatchDTO() {
		super();
	}

	public MatchDTO(int user1, int user2) {
		super();
		this.user1 = user1;
		this.user2 = user2;
	}

	public int getUser1() {
		return user1;
	}

	public void setUser1(int user1) {
		this.user1 = user1;
	}

	public int getUser2() {
		return user2;
	}

	public void setUser2(int user2) {
		this.user2 = user2;
	}
	
	

}
