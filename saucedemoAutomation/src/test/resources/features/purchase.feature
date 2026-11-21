# language: en
Feature: Purchase an Item

  As an Automation Engineer,
  I want to execute an end-to-end purchase flow,
  so that I can demonstrate my test automation skills and knowledge of the selected automation framework.

  Background:
    Given the user is logged in

  @PurchaseFlow
  Scenario: Successfully purchase an item
    Given the user adds an item to the cart
    When completes the checkout process
    Then the order should be successfully placed