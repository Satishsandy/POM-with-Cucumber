package stepDefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class StepDefination extends BaseClass {
	//@Before
/*	public void setup() throws IOException {
		//Reading the Properties
		configprop=new Properties();
		FileInputStream configprofile= new FileInputStream("config.properties");
		configprop.load(configprofile);
		String br=configprop.getProperty("browser");
		if(br.equals("chrome")) {
	// System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
		
		driver= new ChromeDriver();}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",configprop.getProperty("firefoxpath"));
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("browser is not matching");
		}
	}*/
	
	
	///Rediff/chromedriver.exe*/
	@Given("^user Lanunch Chrome browser$")
	public void user_Lanunch_Chrome_browser() throws Throwable {
		driver = new ChromeDriver();
		lp=new LoginPage(driver);
	    
	}

	@When("^user opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
		driver.get(url);
	    
	}

	@When("^user enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String password) throws Throwable {
		lp.setUserName(email);
		lp.setPassword(password);
		
	    
	}

	@When("^Click on Login$")
	public void click_on_Login() throws Throwable {
	  lp.clickLogin();
	  
	}

	@Then("^page Tittle should be \"([^\"]*)\"$")
	public void page_Tittle_should_be(String tittle) throws Throwable {
	  if(driver.getPageSource().contains("Login was unsuccessful.")) {
		  driver.close();
		  
	  }else {
		  Assert.assertEquals(tittle, driver.getTitle());
		  
	  }
	}

	@When("^user click on Log Out Link$")
	public void user_click_on_Log_Out_Link() throws Throwable {
		lp.clickLogout();
		Thread.sleep(3000);
	   
	}

	@Then("^Page Tittle Should be \"([^\"]*)\"$")
	public void page_Tittle_Should_be(String Page) throws Throwable {
		  if(driver.getPageSource().contains("Login was unsuccessful.")) {
			  driver.close();
			  Assert.assertTrue(false);
		  }else {
			 // Assert.assertEquals(Page, driver.getTitle());
		  }
	    
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
		driver.close();
	   
	}//add customers feature
	@Then("^user shows the DashBoard$")
	public void user_shows_the_DashBoard() throws Throwable {
	    addCust=new AddCustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration"
, addCust.getpageTitle());
	}

	@When("^user click the customers Menu$")
	public void user_click_the_customers_Menu() throws Throwable {
		Thread.sleep(3000);
		addCust.clickOnCustomers();
	    
	}

	@When("^click om customers Item$")
	public void click_om_customers_Item() throws Throwable {
		Thread.sleep(3000);
		addCust.clickOnCustomerMenuItem();
	    
	}

	@When("^click on Add customer Page$")
	public void click_on_Add_customer_Page() throws Throwable {
	  Thread.sleep(3000);
	  addCust.cickOnAddnew();
	  Thread.sleep(3000);
	}

	@Then("^user can view Add customers Page$")
	public void user_can_view_Add_customers_Page() throws Throwable {
	  Assert.assertEquals("Customers / nopCommerce administration", addCust.getpageTitle());
	}

	@When("^user enter customer info$")
	public void user_enter_customer_info() throws Throwable {
		Thread.sleep(3000);
	   String email=randomestring()+"@gmail.com";
	   addCust.setEmail(email);
	   addCust.setPassword("test123");
	   addCust.setManagerOfVendor("Vendor 2");
	   addCust.setGender("Male");
	   addCust.setFirstName("Satish");
	   addCust.setLastName("Samdhya");
	   addCust.setDob("3/26/1997");
	   addCust.setCompanyName("Qedge");
	   addCust.setAdminContent("this is testing purpose......");
	}

	@When("^click save button$")
	public void click_save_button() throws Throwable {
	    addCust.clickonSave();
	}

	@Then("^user can view confirmation mesage \"([^\"]*)\"$")
	public void user_can_view_confirmation_mesage(String msg) throws Throwable {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("the new customer has been added successfully"));
	}//
	
	
	//Searching the customer by EmailID
	
	@When("^Enter customer Email$")
	public void enter_customer_Email() throws Throwable {
		searchCust=new SearchCustomerPage(driver);
	    searchCust.setEmail("victoria_victoria@nopCommerce.com");
	    
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable {
	   searchCust.clickSearch();
	   Thread.sleep(5000);
	}

	@Then("^user should be found Email in the search table$")
	public void user_should_be_found_Email_in_the_search_table() throws Throwable {
	   boolean status= searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	   Assert.assertEquals(true, status);
	}
	//search by customer Name
	@When("^Enter Customer FirstName$")
	public void enter_Customer_FirstName() throws Throwable {
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstname("Victoria");
	   
	}

	@When("^Enter Customer LastName$")
	public void enter_Customer_LastName() throws Throwable {
		searchCust.setLastname("Terces");
	    
	}
	@Then("^user should be found Name in the search table$")
	public void user_should_be_found_Name_in_the_search_table() throws Throwable {
		boolean status= searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	    
	}








}
