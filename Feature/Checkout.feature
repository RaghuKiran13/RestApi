@Checkout
Feature: Buying a product
	Description: As a flipkart user, search for required 
  			  product and buy out the product
  			  
    Background: 
    Given the user should be logged into Flipkart application
    
 Scenario: Users searches a product and buys out the product
    When in search, enter the product name
      | product name |
      | micromax tv  |
    Then Product list page must be displayed
    When Select a product 
    Then Product detail page must be displayed
    When Check out the product
    Then Checkout page must be displayed
    When Enter delivery delivery details
    Then Should proceed to payment options
    And user should be logged out successfully