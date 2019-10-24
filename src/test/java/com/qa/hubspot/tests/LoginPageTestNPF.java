package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.LoginPageNPF;

public class LoginPageTestNPF {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPageNPF loginPagenpf;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPagenpf = new LoginPageNPF(driver);

	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPagenpf.getLoginPageTitle();
		System.out.println("The login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPagenpf.verifySignUpLinkDisplayed());
	}

	@Test(priority = 3)
	public void loginTestWithCorrectCredentialsTest() {
		loginPagenpf.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 4)
	public void loginTestWithInCorrectCredentialsTest() {
		String IncorrectText = loginPagenpf.doLoginWithIncorrectCredentials("Test@ggg.com", "tete123");
		Assert.assertEquals(IncorrectText, Constants.INCORRECT_CREDENTIALS_TEXT);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
