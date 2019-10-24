package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class HomePage extends BasePage {

	// 1. Defening Page Locators
	@FindBy(xpath = "//h1[@class='private-page__title']")
	WebElement homePageHeader;

	@FindBy(xpath = "//span[@class='account-name ']")
	WebElement accountName;

	@FindBy(id = "nav-primary-contacts-branch")
	WebElement parentContactMenu;

	@FindBy(id = "nav-secondary-contacts")
	WebElement childContactMenu;

	// Defining constructor to initialize the Page locators
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Defining Page Actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getHomePageHeaderText() {
		return homePageHeader.getText();

	}

	public boolean verifyHomePageHeader() {
		return homePageHeader.isDisplayed();

	}

	public String getAccountName() {
		return accountName.getText();
	}

	public boolean verifyAccountName() {
		return accountName.isDisplayed();
	}

	public void clickOnContacts() {
		parentContactMenu.click();
		TimeUtil.mediumWait();
		childContactMenu.click();
	}

	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
}
