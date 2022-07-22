package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public void AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_HEADER;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")WebElement PHONE_NUMBER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	

	public void validateContactPage(String addcontactheader) {
		Assert.assertEquals(ADD_CONTACT_HEADER.getText(), addcontactheader, "add contact page not found");
	}
    public void insertFullName(String fullname) {
    int genNum = generateRandomNo(999);
	FULL_NAME_ELEMENT.sendKeys(fullname + genNum);
    }
   
    
    public void selectCompany(String company) {
    selectFromDropdown( COMPANY_DROPDOWN_ELEMENT, company);
    }
   
	public void insertEmail (String email) {
    EMAIL_ELEMENT.sendKeys(generateRandomNo(999)+email);
    }
	public void insertPhoneNO(String phoneNo) {
		PHONE_NUMBER_ELEMENT.sendKeys(phoneNo);
	}
    public void insertAddress(String address) {
	ADDRESS_ELEMENT.sendKeys(address);
    }
    public void insertCity(String city) {
	CITY_ELEMENT.sendKeys(city);
    }
}