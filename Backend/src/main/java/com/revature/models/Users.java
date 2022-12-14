package com.revature.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String first_name;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String country;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date date_of_birth;
	
	@Column
	private int question_1_id;
	
	@Column
	private int question_2_id;
	
	@Column
	private int question_3_id;
	
	@Column(length = 1000)
	private byte[] pfp;
	
	
//	Boilerplate
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


public Users(int user_id, String username, String password, String first_name, String city, String state,
		String country, Date date_of_birth, int question_1_id, int question_2_id, int question_3_id, byte[] pfp) {
	super();
	this.user_id = user_id;
	this.username = username;
	this.password = password;
	this.first_name = first_name;
	this.city = city;
	this.state = state;
	this.country = country;
	this.date_of_birth = date_of_birth;
	this.question_1_id = question_1_id;
	this.question_2_id = question_2_id;
	this.question_3_id = question_3_id;
	this.pfp = pfp;
}


public Users(String username, String password, String first_name, String city, String state, String country,
		Date date_of_birth, int question_1_id, int question_2_id, int question_3_id, byte[] pfp) {
	super();
	this.username = username;
	this.password = password;
	this.first_name = first_name;
	this.city = city;
	this.state = state;
	this.country = country;
	this.date_of_birth = date_of_birth;
	this.question_1_id = question_1_id;
	this.question_2_id = question_2_id;
	this.question_3_id = question_3_id;
	this.pfp = pfp;
}


public int getUser_id() {
	return user_id;
}


public void setUser_id(int user_id) {
	this.user_id = user_id;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getFirst_name() {
	return first_name;
}


public void setFirst_name(String first_name) {
	this.first_name = first_name;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getState() {
	return state;
}


public void setState(String state) {
	this.state = state;
}


public String getCountry() {
	return country;
}


public void setCountry(String country) {
	this.country = country;
}


public Date getDate_of_birth() {
	return date_of_birth;
}


public void setDate_of_birth(Date date_of_birth) {
	this.date_of_birth = date_of_birth;
}



public byte[] getpfp() {
	return pfp;
}


public void setpfp(byte[] pfp) {
	this.pfp = pfp;
}

public int getQuestion_1_id() {
	return question_1_id;
}

public void setQuestion_1_id(int question_1_id) {
	this.question_1_id = question_1_id;
}

public int getQuestion_2_id() {
	return question_2_id;
}

public void setQuestion_2_id(int question_2_id) {
	this.question_2_id = question_2_id;
}

public int getQuestion_3_id() {
	return question_3_id;
}

public void setQuestion_3_id(int question_3_id) {
	this.question_3_id = question_3_id;
}
	
}