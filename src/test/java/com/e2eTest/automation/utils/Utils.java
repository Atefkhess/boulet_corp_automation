package com.e2eTest.automation.utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BasePage {

		/** properties. */
		protected Properties properties;

		/** config fis. */
		protected FileInputStream configFis;

		/** driver. */
		private static WebDriver driver;
		/**
		 * Instanciation de common utils.
		 */
		public Utils() { 
				super(driver);
				Utils.driver = Setup.getDriver();
			}
	public void get(String url) {
		driver.get(url);
	}
	
	public void waitForElementToBeClickable(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void click(WebElement elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			waitForElementToBeClickable(elementAttr);
			driver.findElement((By) elementAttr).click();
		} else {
			elementAttr.click();
		}
	}
	 public void assertNotEquals(String actual, String expected) {
	        Assert.assertNotEquals(actual, expected);
	    }
	 public Boolean isElementDisplayed(WebElement element) {
			return element.isDisplayed();
		}
	 public  String getCurrentUrl() {
			//System.out.println(driver.getCurrentUrl());
	        return driver.getCurrentUrl();       
	    }

}
