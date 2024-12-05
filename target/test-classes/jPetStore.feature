Feature: Pet Store Website

  @PetStore
  Scenario: Test Login with valid data
    Given I am at the Pet Store Login page
    When I enter a valid username and password
    Then I should be redirected to the home page

  @PetStore
  Scenario: Test Register with valid data
    Given I am at the Pet Store Register page
    When I enter valid user and account
    And I click on Save Account
    Then I should be redirected from Register to the home page

  @PetStore
  Scenario: Make purchase on the website
    Given I am able to login using valid credentials
    And I search a "Iguana" food in the "Reptiles" area
    And I add a product to my Cart
    When I click on Proceed to checkout
    And I click to submit the order
    Then I should see an order confirmation
