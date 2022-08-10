package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="question_2")
@Component
public class QuestionTwo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_2_id;
	
	@Column(nullable = false)
	private String answer;

	//boilerplate
	public QuestionTwo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionTwo(int question_2_id, String answer) {
		super();
		this.question_2_id = question_2_id;
		this.answer = answer;
	}

	public QuestionTwo(String answer) {
		super();
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QuestionTwo [question_2_id=" + question_2_id + ", answer=" + answer + "]";
	}

	public int getQuestion_2_id() {
		return question_2_id;
	}

	public void setQuestion_2_id(int question_2_id) {
		this.question_2_id = question_2_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
}
