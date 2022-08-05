Feature: Registration
    The app needs a method for registering a new user. 

    Scenario: Registering a new user
            Given a new user opens the app
            When the user registers with their First Name
            And their Email (username)
            And their Password
            And their Confirm Password
            And their City
            And their State/Province
            And their Country
            And their Age (must be over 18)
            And their Favorite Coding Language
            And their job description
            And their pronunciation of SQL 
            And their picture
            And clicks the Register button
            Then the user is registered in the Database
            And a message is displayed that says "You have successfully registered!"
            And the user is taken to the login page

    