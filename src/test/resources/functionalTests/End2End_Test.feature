Feature: Automated QA Technical Assessment Test
Description: The purpose of the functional UI test is to demonstrate that the candidate can make use of selenium

Scenario Outline: Customer place an order by purchasing an item from search
	Given user is on Home Page
	Then Navigate to RESOURCES
	And From the drop down, click on White Papers & eBooks
	Then Verify Title reads White Papers
	And Click on any white paper tile (eg. Click on UCITS Whitepaper)
	Then Enter person's details
	And Click Send me a copy
	Then Add screenshot of the error messages
	And Validate all error messages