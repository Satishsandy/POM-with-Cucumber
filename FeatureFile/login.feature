Feature: Login


Scenario: Successfully Login with Valid Credentials
Given user Lanunch Chrome browser
When user opens URL "https://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then page Tittle should be "Dashboard / nopCommerce adminstration"
When user click on Log Out Link
Then Page Tittle Should be "Your store.Login"
And close browser 

Scenario Outline: Successfully Login with Valid Credentials

Given user Lanunch Chrome browser
When user opens URL "https://admin-demo.nopcommerce.com/login"
And user enters Email as "<email>" and Password as "<password>"
And Click on Login
Then page Tittle should be "Dashboard / nopCommerce adminstration"
When user click on Log Out Link
Then Page Tittle Should be "Your store.Login"
And close browser 
Examples:
|email|password|
|admin@yourstore.com|admin|
|admin@yourstore.com|admin123|
