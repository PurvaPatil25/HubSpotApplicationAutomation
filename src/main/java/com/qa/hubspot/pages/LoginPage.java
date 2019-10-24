package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class LoginPage extends BasePage {

	// 1. Defining the Page objects with the help of Page Factory

	@FindBy(id = "username")
	WebElement emailID;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "loginBtn")
	WebElement loginButton;

	@FindBy(linkText = "Sign up")
	WebElement SignUpLink;

	// 2. Creating the constructor of login page & initialize the page objects

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 3. Defining PageActions or Page library:

	public String getLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean verifySignUpLinkDisplayed() {
		return SignUpLink.isDisplayed();

	}

	public HomePage doLogin(String username, String pwd) {
		System.out.println("credentials : " + username + "/ " + pwd);
		emailID.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		TimeUtil.mediumWait();
		return new HomePage(driver);

	}

}
