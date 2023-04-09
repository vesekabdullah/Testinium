Feature: some customer activities on beymen

  Scenario: the customer should be add to cart and also should be delete products
    Given the customer gets on main page
    When the customer write şort product name from excel
    And the customer clean searchBox
    And the customer write gömlek product name from excel
    And the customer click on search box
    And the customer select one of products
    And the info about products written on file
    And the customer add to cart that product
    And the customer compare price
    And the customer decrease the number of products
    Then the customer delete the products
    Then the customer control the cart empty or not

