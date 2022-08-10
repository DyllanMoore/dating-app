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

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name ="username", nullable = false)
	private String username;
	
	@Column(name ="password", nullable = false)
	private String password;
	
	@Column(name ="firstName", nullable = false)
	private String firstName;
	
	@Column(name ="city", nullable = false)
	private String city;
	
	@Column(name ="state", nullable = false)
	private String state;
	
	@Column(name ="country", nullable = false)
	private String country;
	
	@Column(name ="dateOfBirth", nullable = false)
	private Date dateOfBirth;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question1Id")
	private QuestionOne questionOne;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question2Id")
	private QuestionTwo questionTwo;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question3Id")
	private QuestionThree questionThree;

	

	//boilerplate
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int userId, String username, String password, String firstName, String city, String state,
			String country, Date dateOfBirth, QuestionOne questionOne, QuestionTwo questionTwo,
			QuestionThree questionThree) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
		this.questionOne = questionOne;
		this.questionTwo = questionTwo;
		this.questionThree = questionThree;
	}



	public User(String username, String password, String firstName, String city, String state, String country,
			Date dateOfBirth, QuestionOne questionOne, QuestionTwo questionTwo, QuestionThree questionThree) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
		this.questionOne = questionOne;
		this.questionTwo = questionTwo;
		this.questionThree = questionThree;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", city=" + city + ", state=" + state + ", country=" + country + ", dateOfBirth="
				+ dateOfBirth + ", questionOne=" + questionOne + ", questionTwo=" + questionTwo + ", questionThree="
				+ questionThree + "]";
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
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



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
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



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	
	
}
