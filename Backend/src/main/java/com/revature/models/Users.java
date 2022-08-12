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
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_1_id")
	private QuestionOne questionOne;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_2_id")
	private QuestionTwo questionTwo;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_3_id")
	private QuestionThree questionThree;
	
	@Column
	private String images;
	
	
//	Boilerplate
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


public Users(int user_id, String username, String password, String first_name, String city, String state,
		String country, Date date_of_birth, QuestionOne questionOne, QuestionTwo questionTwo,
		QuestionThree questionThree, String images) {
	super();
	this.user_id = user_id;
	this.username = username;
	this.password = password;
	this.first_name = first_name;
	this.city = city;
	this.state = state;
	this.country = country;
	this.date_of_birth = date_of_birth;
	this.questionOne = questionOne;
	this.questionTwo = questionTwo;
	this.questionThree = questionThree;
	this.images = images;
}


public Users(String username, String password, String first_name, String city, String state, String country,
		Date date_of_birth, QuestionOne questionOne, QuestionTwo questionTwo, QuestionThree questionThree,
		String images) {
	super();
	this.username = username;
	this.password = password;
	this.first_name = first_name;
	this.city = city;
	this.state = state;
	this.country = country;
	this.date_of_birth = date_of_birth;
	this.questionOne = questionOne;
	this.questionTwo = questionTwo;
	this.questionThree = questionThree;
	this.images = images;
}


@Override
public String toString() {
	return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name="
			+ first_name + ", city=" + city + ", state=" + state + ", country=" + country + ", date_of_birth="
			+ date_of_birth + ", questionOne=" + questionOne + ", questionTwo=" + questionTwo + ", questionThree="
			+ questionThree + ", images=" + images + "]";
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


public QuestionOne getQuestionOne() {
	return questionOne;
}


public void setQuestionOne(QuestionOne questionOne) {
	this.questionOne = questionOne;
}


public QuestionTwo getQuestionTwo() {
	return questionTwo;
}


public void setQuestionTwo(QuestionTwo questionTwo) {
	this.questionTwo = questionTwo;
}


public QuestionThree getQuestionThree() {
	return questionThree;
}


public void setQuestionThree(QuestionThree questionThree) {
	this.questionThree = questionThree;
}


public String getImages() {
	return images;
}


public void setImages(String images) {
	this.images = images;
}

	
	

}