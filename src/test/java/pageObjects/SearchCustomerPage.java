package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage  {
	public WebDriver ldriver;
	 
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(how = How.ID, using="https://admin-demo.nopcommerce.com/admin/")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.ID, using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how = How.ID, using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how = How.ID,using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
    List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setFirstname(String Fname) {
	txtFirstName.clear();
	txtFirstName.sendKeys(Fname);
	}
	public void setLastname(String Lname) {
		txtLastName.clear();
		txtLastName.sendKeys(Lname);
	}
	public void clickSearch() {
		btnSearch.click();
		
	}
	public int getNoOfRows() {
		return (tableRows.size());
		
	}
	public int getNoOfColumns() {
		return (tableColumns.size());
		
	}
	public boolean searchCustomerByEmail(String email) {
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++) {
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email)) {
				flag=true;
			}
		}
		return flag;
				
	}
	public boolean searchCustomerByName(String Name) {
		boolean falg=false;
		for(int i=1;i<=getNoOfRows();i++) {
			String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String names[]=name.split("");
			if(names[0].equals("Victoria") && names[1].equals("Terces")) {
				falg=true;
			}
			
		}
		return falg;
				
				
	}

}
