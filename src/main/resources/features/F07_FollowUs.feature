Feature: F07_FollowUs | users could open followUs links

  Background: user login with valid data
    When user navigate to login page
    And user enter "emran@gmail.com" and "nopassword!"
    Then user click on login button
    And user could login successfully and go to home page

  Scenario: user click on facebook link
    When user opens facebook link
    Then "https://www.facebook.com/nopCommerce" is opened in new tab


  Scenario: user click on twitter link
    When user opens twitter link
    Then "https://twitter.com/nopCommerce" is opened in new tab


  Scenario: user click on rss link
    When user opens rss link
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab


  Scenario: user click on youtube link
    When user opens youtube link
    Then "https://www.youtube.com/user/nopCommerce" is opened in new tab