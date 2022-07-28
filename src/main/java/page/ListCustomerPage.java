package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage {

	WebDriver driver;

	public void  ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")WebElement ADDCUSTOMER_HEADER_ELEMENT;
	
	
	
	public void validateAddcustomerHeader(String addcustomerheader) {
		Assert.assertEquals(ADDCUSTOMER_HEADER_ELEMENT.getText(),addcustomerheader, "add customer header not found");
	}
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	
	public void validateinsertedcustomer() {
		
	for(int i = 1 ; i <= 10; i++) {
		String validatedcustomers = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
		System.out.println(validatedcustomers);}
		
	}
	
	}
