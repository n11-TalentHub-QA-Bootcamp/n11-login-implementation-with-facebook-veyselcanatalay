Feature: N11 Login Functionality With Facebook

  In order to do shopping
  As a valid N11 customer
  User want to login successfully

  Scenario: Login Successful
    Given User navigate to N11 homepage
    When User enter valid credentials "my_mail@gmail.com" and "my_password" with facebook in login page
    Then User should see email "my_mail@gmail.com" in main page