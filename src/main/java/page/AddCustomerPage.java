package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public void AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")
	WebElement ADD_CONTACT_HEADER;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_NUMBER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]")
	WebElement CLICK_OK_BUTTON;

	public void validateContactPage(String addcontactheader) {
		Assert.assertEquals(ADD_CONTACT_HEADER.getText(), addcontactheader, "add contact page not found");
	}

	String insertedName;

	public void insertFullName(String fullname) {
		int genNum = generateRandomNo(999);
		insertedName = fullname + genNum;
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}

	public void selectCompany(String company) {
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNo(999) + email);
	}

	public void insertPhoneNO(String phoneNo) {
		PHONE_NUMBER_ELEMENT.sendKeys(phoneNo + generateRandomNo(999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		STATE_ELEMENT.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}

	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}

	// to customize xpath and then looping through
	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[3]/td[3]

	// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]

	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";

	public void validateInsertedcustomerAndDelete() {

		for (int i = 1; i <= 10; i++) {
			String namesFromList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
					
		
			// to print first 10 inserted customers
		//	System.out.println(namesFromList);
		
			// to validate new customer
		//	Assert.assertEquals(namesFromList, insertedName, "inserted name not available");
		//	break;
			
			if(namesFromList.equalsIgnoreCase(insertedName)) {
				System.out.println("inserted name exist");
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
		}
	
	}

	public void clickOkButtonToDelete() {
		CLICK_OK_BUTTON.click();
		
	}

}