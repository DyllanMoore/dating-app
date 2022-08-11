package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="match")
@Component
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int match_id;
	
	@Column(nullable = false)
	private int user1;
	
	@Column(nullable = false)
	private int user2;
	
	@Column(nullable = false)
	private boolean mutual;

	public Match() {
		super();
	}
	
	//Constructor without match_id for inserting new match
	public Match(int user1, int user2, boolean mutual) {
		super();
		this.user1 = user1;
		this.user2 = user2;
		this.mutual = mutual;
	}
	
	//Full Constructor
	public Match(int match_id, int user1, int user2, boolean mutual) {
		super();
		this.match_id = match_id;
		this.user1 = user1;
		this.user2 = user2;
		this.mutual = mutual;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
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

	public boolean isMutual() {
		return mutual;
	}

	public void setMutual(boolean mutual) {
		this.mutual = mutual;
	}
	
	
	
	
	
}
