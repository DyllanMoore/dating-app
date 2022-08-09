Feature: Registration
    The app needs a method for registering a new user. 

    Scenario: Registering a new user
            Given a new user opens the app and clicks on the register button
            When the user registers with their Email as username
            And their Password
            And their Confirm Password
            And their First Name
            And their City
            And their State/Province
            And their Country
            And their Age (must be over 18)
            And their Favorite Coding Language
            And their Job Description
            And their Pronunciation of SQL 
            And their Picture
            And clicks the Register button
            Then the user is registered in the Database
            And a message is displayed that says "You have successfully registered!"
            And the user is taken to the login page

    