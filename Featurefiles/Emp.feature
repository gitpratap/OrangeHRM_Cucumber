@tag	
Feature: Employee registration
@tag1
 Scenario: Check Admin able to Registered a new Employee or not
   
   
 	 Given i open with  the url "http://orangehrm.qedgetech.com"
   Then i should see the login page	
   When i entered the username "Admin"
   And i entered the password "Qedge123!@#"
   And i click on login button
   Then i should see the Admin module 
   When i goto add employee page
   And i entered first name as "Moye"
   And i entered last name as "Moye"
   And i click on save button
   Then i should the registered employee in Employee List
   When i click logout
   Then i should see the login page
   When i close the browser
       