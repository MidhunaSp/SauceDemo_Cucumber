Feature: Login Functionality

	Scenario: Complete End to End Flow
		Given Iam on the SauceDemo Login page
		When I enter "standard_user" and password "secret_sauce"
		And I click the login button
		Then I should be redirected to the dashboard

		When I select sort "Price(low to high)" from the dropdown
		And I add the first product to the cart
		And I click on the shopping cart icon
		Then I should be on the cart page
		
		When I click the "Checkout" button
		And I enter checkout information as "Midhuna","Varshini","600053"
		And I click the "Continue" button
		And I click the "Finish" button
		Then I should see the "Thank you for your order!" message
  