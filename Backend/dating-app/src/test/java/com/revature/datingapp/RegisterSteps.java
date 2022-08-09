package com.revature.datingapp;

import org.junit.runner.RunWith;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/revature/datingapp/features", 
    glue = "src/test/java/com/revature/datingapp/steps"
    )

public class RegisterSteps {
    @Given("^a new user opens the app and clicks on the register button$")
    public void a_new_user_opens_the_app_and_clicks_on_the_register_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the user registers with their Email as username$")
    public void the_user_registers_with_their_information() {
        // Write code here that turns the phrase above into concrete actions
    }



}
