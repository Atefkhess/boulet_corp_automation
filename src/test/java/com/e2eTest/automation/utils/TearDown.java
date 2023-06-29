package com.e2eTest.automation.utils;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class TearDown {

	/**
	 * This method is used to close browser. This method is called after the
	 * invocation of each test method in given class.
	 * 
	 * @After Methods annotated with @After execute after every scenario.
	 */
	@After
	public void quitDriver(Scenario scenario) {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
			Allure.addAttachment("Failed step", new ByteArrayInputStream(screenshot));
		}
		Setup.getDriver().quit();
		Setup.LOGGER.info("scenario :"+ scenario.getName() +"-finished.status "+ scenario.getStatus());
	}

}
