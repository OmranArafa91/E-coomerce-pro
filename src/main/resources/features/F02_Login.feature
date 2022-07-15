Feature: F02_Login | user should be able to login to the system


  Scenario: user could login with valid data

    Given user navigate to login page
    And user enter "emran@gmail.com" and "nopassword!"
    And user click on login button
    Then user could login successfully and go to home page

