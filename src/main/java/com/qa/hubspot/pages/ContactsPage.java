package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ContactsPage extends BasePage {

	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement createContactButton;

	@FindBy(id = "UIFormControl-15")
	WebElement email;

	@FindBy(id = "UIFormControl-16")
	WebElement firstName;

	@FindBy(id = "UIFormControl-18")
	WebElement lastName;

	@FindBy(id = "UIFormControl-22")
	WebElement jobTitle;

	@FindBy(xpath = "//li//div[text()='Create contact']")
	WebElement secondContactButton;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String emailVal, String firstNameval, String lastNameval, String jobTitleval) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(createContactButton));
		createContactButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailVal);
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(firstNameval);
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastNameval);
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jobTitleval);
		wait.until(ExpectedConditions.elementToBeClickable(secondContactButton));
		secondContactButton.click();

	}

}
