package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;
	@Test
	public void userShouldBeAbleToCreatNewCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickSigninButton();
	    DashboardPage dashboardpage = PageFactory.initElements(driver,DashboardPage.class);
		dashboardpage.validateDashboardPage("Dashboard");
		dashboardpage.clickCustomerMenuElement();
		dashboardpage.clickAddCstomerMenuElement();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateContactPage("Add Contact");
		addCustomerPage.insertFullName("Rabia");
		addCustomerPage.selectCompany("Techfios");
		addCustomerPage.insertEmail("abc786@gmail.com");
		addCustomerPage.insertPhoneNO("12345");
		addCustomerPage.insertAddress("Richardson");
		addCustomerPage.insertCity("richardson TX");
	}
	
}
