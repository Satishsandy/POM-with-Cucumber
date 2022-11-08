Feature: Customers

Background: Below steps are common for every Scenario
Given user Lanunch Chrome browser
When user opens URL "https://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then user shows the DashBoard
Scenario: Add the customers

When user click the customers Menu
And click om customers Item
And click on Add customer Page
Then user can view Add customers Page
When user enter customer info
And click save button
Then user can view confirmation mesage "the new customer has been added successfully"
And close browser

Scenario: Search Customer by EmailId
When user click the customers Menu
And click om customers Item
And Enter customer Email
When Click on search button
Then user should be found Email in the search table
And close browser

Scenario: Search Customer by Name
When user click the customers Menu
And click om customers Item
And Enter Customer FirstName
And Enter Customer LastName
When Click on search button
Then user should be found Name in the search table
And close browser
