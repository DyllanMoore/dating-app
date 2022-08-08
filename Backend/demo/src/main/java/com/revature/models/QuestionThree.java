package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="question_3")
@Component
public class QuestionThree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_3_id;
	
	@Column(nullable = false)
	private String answer;

	
	//boilerplate
	public QuestionThree() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
