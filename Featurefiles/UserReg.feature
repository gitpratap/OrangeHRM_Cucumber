
@tag
Feature: User Registration
  Check Admin able to registered a new user or not

  @tag1
  Scenario: Registration of a new user via Admin with the valid inputs
   Given i open with  the url "http://orangehrm.qedgetech.com"
   Then i should see the login page	
   When i entered the username "Admin"
   And i entered the password "Qedge123!@#"
   And i click on login button
   Then i should see the Admin module 
   When i goto add user page
   When i input all the valid data "baji sk" and "tfdfcsld" and "Abcde123#@!$"
   And i click on save button
   Then i should see the registered user in the list "tfdfcsld"
   When i click logout
   Then i should see the login page
   When i close the browser

   