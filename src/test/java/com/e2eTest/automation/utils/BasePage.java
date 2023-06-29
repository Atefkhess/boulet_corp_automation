package com.e2eTest.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the declaration of the driver. and contains the
 * declaration of the logger.
 */
public class BasePage {
	/** log. */
	protected static Logger LOGGER = LogManager.getLogger(BasePage.class.getName());
	protected WebDriver driver;

	/**
	 * Instanciation de base page.
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
