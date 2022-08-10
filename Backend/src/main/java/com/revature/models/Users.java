package com.revature.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String first_name;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String country;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date_of_birth;
	
	@Column
	private int question_1_fk;
	
	@Column
	private int question_2_fk;
	
	@Column
	private int question_3_fk;
	

	public Users() {
		super();
	}
	
	//Constructor for inserting new user into database
	public Users(String username, String password, String first_name, String city, String state, String country,
			Date date_of_birth, int question_1_fk, int question_2_fk, int question_3_fk) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.date_of_birth = date_of_birth;
		this.question_1_fk = question_1_fk;
		this.question_2_fk = question_2_fk;
		this.question_3_fk = question_3_fk;
	}

	//Full Constructor
	public Users(int user_id, String username, String password, String first_name, String city, String state,
			String country, Date date_of_birth, int question_1_fk, int question_2_fk, int question_3_fk) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.date_of_birth = date_of_birth;
		this.question_1_fk = question_1_fk;
		this.question_2_fk = question_2_fk;
		this.question_3_fk = question_3_fk;
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

	public int getQuestion_1_fk() {
		return question_1_fk;
	}

	public void setQuestion_1_fk(int question_1_fk) {
		this.question_1_fk = question_1_fk;
	}

	public int getQuestion_2_fk() {
		return question_2_fk;
	}

	public void setQuestion_2_fk(int question_2_fk) {
		this.question_2_fk = question_2_fk;
	}

	public int getQuestion_3_fk() {
		return question_3_fk;
	}

	public void setQuestion_3_fk(int question_3_fk) {
		this.question_3_fk = question_3_fk;
	}
	
	
	
	
	
}
