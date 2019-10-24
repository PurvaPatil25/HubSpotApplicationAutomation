package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Title of home page is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		Assert.assertTrue(homePage.verifyHomePageHeader());
		Assert.assertEquals(homePage.getHomePageHeaderText(), Constants.HOME_PAGE_HEADER);

	}

	@Test(priority = 3)
	public void verifyHomePageAccountNameTest() {
		Assert.assertTrue(homePage.verifyAccountName());
		Assert.assertEquals(homePage.getAccountName(), Constants.HOME_PAGE_ACCOUNTNAME);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
