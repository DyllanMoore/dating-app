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


	public QuestionThree(int question_3_id, String answer) {
		super();
		this.question_3_id = question_3_id;
		this.answer = answer;
	}


	public QuestionThree(String answer) {
		super();
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "QuestionThree [question_3_id=" + question_3_id + ", answer=" + answer + "]";
	}


	public int getQuestion_3_id() {
		return question_3_id;
	}


	public void setQuestion_3_id(int question_3_id) {
		this.question_3_id = question_3_id;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
	
}
