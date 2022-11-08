package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id= "Email")
	@CacheLookup
	WebElement txtEmail;
	
	
	@FindBy(id= "Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath= "(//button[normalize-space()='Log in'])[1]")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement btnLogout;
	
	
	public void setUserName(String usname) {
		txtEmail.clear();
		txtEmail.sendKeys(usname);
	}
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
   public void clickLogin() {
	   btnLogin.click();
   }
   public void clickLogout() {
	   btnLogout.click();
   }
	
}
