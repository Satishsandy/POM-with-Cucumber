package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	By lnkCustomers_menu= By.xpath("(//a[@class='nav-link'])[21]");
	By lnkCustomers_menuitem=By.xpath("(//a[@href='/Admin/Customer/List'])[1]");
	
	By btnAddnew= By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("(//input[@id='Password'])[1]");
	By txtFirstname= By.xpath("(//input[@id='FirstName'])[1]");
	By txtLastname= By.xpath("(//input[@id='LastName'])[1]");
	
	By drpmgofVendor=By.xpath("(//select[@id='VendorId'])[1]");
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("//input[@id='Gender_Female']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName= By.xpath("(//input[@id='Company'])[1]");
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.xpath("(//i[@class='far fa-save'])[1]");
	
	
	public String getpageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomers() {
		ldriver.findElement(lnkCustomers_menu).click();
	}
	public void clickOnCustomerMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	public void cickOnAddnew() {
		ldriver.findElement(btnAddnew);
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	public void setManagerOfVendor(String value) {
		Select drp= new Select(ldriver.findElement(drpmgofVendor));
		drp.selectByVisibleText(value);
		
	}
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female")) {
			ldriver.findElement(rdFemaleGender).click();
		}
		else {
			ldriver.findElement(rdMaleGender).click();
		}
		 
	}
	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstname).sendKeys(fname);
	}
	public void setLastName(String lname) {
		ldriver.findElement(txtLastname).click();
	}
	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompanyName);
	}
	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	public void clickonSave() {
		ldriver.findElement(btnSave).click();
	}
	
	
	
	
	
	
	
	
	
	

}
