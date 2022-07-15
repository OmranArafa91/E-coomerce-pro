Feature: F03_ChangeCurrency | user could switch between currencies [$, €]


  Scenario: guest user can switch between currencies
    When user select “Euro” from currency dropdown list
    Then euro is selected successfully

