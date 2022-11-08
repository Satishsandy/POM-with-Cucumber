package stepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public Properties configprop;
	
	
	//created for generating random string for email
	public static String randomestring() {
		String generatedString1= RandomStringUtils.randomAlphabetic(5);
		return null;
		
	}
}
