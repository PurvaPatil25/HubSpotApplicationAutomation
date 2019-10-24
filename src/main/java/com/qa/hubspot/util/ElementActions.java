package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementActions extends BasePage {

	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to create the WebElement on the basis of the given By
	 * locator.Also handling exception with this getElement()
	 * 
	 * @param locator
	 * @return element
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception occured while creating webelement " + locator);

		}
		return element;

	}

	/**
	 * This method is used to find whether the element is displayed or not
	 * 
	 * @param locator
	 * @return
	 */
	public boolean elementIsDisplayed(By locator) {
		waitForElementPresent(locator);
		return getElement(locator).isDisplayed();
	}

	/**
	 * This method is used to click the element
	 * 
	 * @param locator
	 */
	public void elementClick(By locator) {
		getElement(locator).click();

	}

	/**
	 * This method is used to pass the value with the help of send keys
	 * 
	 * @param locator
	 * @param value
	 */
	public void elementSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

	public String getPageTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println("Some exception occured while fetching the title " + title);
		}
		return title;
	}

	/**
	 * Creating explicitly wait for the element present
	 * 
	 * @param locator
	 */
	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void waitForTitlePresent(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
	}

}
