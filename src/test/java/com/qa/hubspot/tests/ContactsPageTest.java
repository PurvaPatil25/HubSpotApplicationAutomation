package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@DataProvider(name = "getContactsTestData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = ExcelUtil.getTestData("Contacts");
		return contactsData;

	}

	@Test(dataProvider = "getContactsTestData")
	public void createNewContactsTest(String emailVal, String firstNameval, String lastNameval, String jobTitleval) {
		contactsPage.createNewContact(emailVal, firstNameval, lastNameval, jobTitleval);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
