Feature: F08_WishList  |  guest user could add products to wishlist



  Scenario:  after adding item to wishlist success message is Displayed
    When add item to wishlist
    Then wishlist notification success is displayed


  Scenario: number of wishlist items in home page is increased

    When add item to wishlist
    Then wishlist notification success is displayed
       And user get the number of wishlist items after adding item
       Then the number of wishlist increased


  Scenario: added items are displayed on wishlist

    When add item to wishlist
    Then wishlist notification success is displayed
        And user get the number of wishlist items after adding item
        And user go to wishlist page
        Then the number of items greater than zero in wishlist page
