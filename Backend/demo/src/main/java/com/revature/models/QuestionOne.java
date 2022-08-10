package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="question_1")
@Component
public class QuestionOne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_1_id;
	
	@Column(nullable = false)
	private String answer;
	
	//boilerplate
	public QuestionOne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionOne(int question_1_id, String answer) {
		super();
		this.question_1_id = question_1_id;
		this.answer = answer;
	}

	public QuestionOne(String answer) {
		super();
		this.answer = answer;
	}

	public int getQuestion_1_id() {
		return question_1_id;
	}

	public void setQuestion_1_id(int question_1_id) {
		this.question_1_id = question_1_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
}
