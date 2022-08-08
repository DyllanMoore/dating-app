package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.QuestionOne;
import com.revature.models.QuestionThree;
import com.revature.models.QuestionTwo;
import com.revature.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	
	//login functionality
	public Optional<User> findByUsernameAndPassword(String username, String password);
	
	//Find by Location
	public Optional<List<User>> findByCityAndState(String city, String state);
	
	//Find by interest
	public Optional<List<User>> findByQuestionOneAndQuestionTwoAndQuestionThree(QuestionOne questionOne, QuestionTwo questionTwo, QuestionThree questionThree);
}
