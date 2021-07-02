Feature: S07
  Scenario: S07_1
    Given a user7
    When presses on see details
    Then the system shows the order details
  Scenario: S07_2
    Given a user7
    When loads the orders history
    Then the system shows the selected order details
  Scenario: S07_3
    Given a user7
    When loads the orders history
    Then the system shows the user's orders history