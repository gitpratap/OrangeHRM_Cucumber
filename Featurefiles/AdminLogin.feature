
@tag
Feature: Login Test
  Checking Admin Login with Valid and Validx Credentials		

  @tag1
  Scenario: Admin Login with valid credentials 
    Given i open with  the url "http://orangehrm.qedgetech.com"
    Then i should see the login page	
    When i entered the username "Admin"
    And i entered the password "Qedge123!@#"
    And i click on login button
   	Then i should see the Admin module 
    When i click on Logout
    Then i should see the login page
    When i close the browser

  @tag2
  Scenario Outline: Admin Login with Inalid data
   	Given i open with  the url "http://orangehrm.qedgetech.com"
    Then i should see the login page
  	When i entered the username "<uname>"
  	And i entered pwd as "<pword>"
    And i click on login button
		Then i should see th error message
		And i close the browser
	
    Examples: 
      | uname | pword |
      | Admin |  abm  | 
      | abc |Qedge123!@| 
      |  | | 
      
      
      
      
      
      