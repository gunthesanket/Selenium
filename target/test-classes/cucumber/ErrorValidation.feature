

@Error
Feature: Error Validation 

Background:
	Given I landed on Ecommerce Page

@Error2
Scenario Outline: Error Validation with correct_incorrect id and pass
Given Logged in with username <name> and password <password>
Then "Incorrect email or password." error message is displayed on ConfirmationPage


    Examples: 
      | name  								|  password		    |	
      |sanketgunthe@gmail.com | Saqnku8983#      |
      |sanketgunthe@gmail.com | Sanku8983#      |