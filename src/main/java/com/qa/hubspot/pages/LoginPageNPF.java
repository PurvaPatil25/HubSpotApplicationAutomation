package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;

public class LoginPageNPF extends BasePage {

	ElementActions elementActions;
	// 1. Defining page objects with the help of By locator

	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By SignUpLink = By.linkText("Sign up");
	By incorrectLoginText = By.xpath("//h2[@class='is--heading-5 private-alert__title']");

	// 2. Creating the constructor of login page & initialize the page objects

	public LoginPageNPF(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}

	// 3. Defining PageActions or Page library:

	public String getLoginPageTitle() {
		elementActions.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE);
		return elementActions.getPageTitle();
	}

	public boolean verifySignUpLinkDisplayed() {
		return elementActions.elementIsDisplayed(SignUpLink);
	}

	public HomePage doLogin(String username, String pwd) {
		System.out.println("credentials : " + username + "/ " + pwd);
		elementActions.elementSendKeys(emailId, username);
		elementActions.elementSendKeys(password, pwd);
		elementActions.elementClick(loginButton);
		elementActions.waitForTitlePresent(Constants.HOME_PAGE_TITLE);
		// TimeUtil.mediumWait();
		return new HomePage(driver);

	}

	public String doLoginWithIncorrectCredentials(String username, String pwd) {
		System.out.println("credentials : " + username + "/ " + pwd);
		elementActions.elementSendKeys(emailId, username);
		elementActions.elementSendKeys(password, pwd);
		elementActions.elementClick(loginButton);
		return elementActions.getElement(incorrectLoginText).getText();

	}
}