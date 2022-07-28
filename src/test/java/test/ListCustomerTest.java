package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
	WebDriver driver;
	@Test
	public void userShouldBeAbleToValidateNewCustomer() throws InterruptedException  {
		
		driver = BrowserFactory.init();
		
		// in POM we creat the object by using pagefactory.
		
		//Loginpage object.
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickSigninButton();
		
		// Dashboardpage object.
	    DashboardPage dashboardpage = PageFactory.initElements(driver,DashboardPage.class);
		dashboardpage.validateDashboardPage("Dashboard");
		dashboardpage.clickCustomerMenuElement();
		dashboardpage.clickAddCstomerMenuElement();
		
		//Addcustomerpage object.
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateContactPage("Add Contact");
		addCustomerPage.insertFullName("Rabia");
		addCustomerPage.selectCompany("Techfios");
		addCustomerPage.insertEmail("abc786@gmail.com");
		addCustomerPage.insertPhoneNO("12345");
		addCustomerPage.insertAddress("Richardson");
		addCustomerPage.insertCity("richardson TX");
		addCustomerPage.insertState("texas");
		addCustomerPage.insertZip("75081");
		addCustomerPage.selectCountry("Virgin Islands, U.S.");
		addCustomerPage.clickSaveButton();
		
		dashboardpage.clickListCustomerMenu();
		
		//Listcustomerpage object.
		ListCustomerPage listcustomer = PageFactory.initElements(driver, ListCustomerPage.class);
		listcustomer.validateAddcustomerHeader("Add Customer");
	
		listcustomer.validateinsertedcustomer();
		
	
	}

	


}
