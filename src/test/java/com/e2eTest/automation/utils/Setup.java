package com.e2eTest.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;




import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {

	private static WebDriver driver;
	protected static Logger LOGGER = LogManager.getLogger(BasePage.class.getName());
	/**
	 * This method is used to open browser. This method is called before the
	 * invocation of each test method in the given class. In this method we need to
	 * pass browser name which will invoke the respective driver.
	 * 
	 * @throws MalformedURLException the malformed URL exception
	 * @Before Methods annotated with @Before will execute before every scenario.
	 */

	@Before // Hooks Of Cucumber
	public void setWebDriver(Scenario scenario) {
		LOGGER.info("scenario :" + scenario.getName() + "-started");
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}
		switch (browser) {
		case "chrome":
			/*System.setProperty("webdriver.chrome.driver", "src/test/resource/drivers/win/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver();
			*/
			
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			// Both do the same thing
			driver.manage().window().maximize();
			chromeOptions.addArguments("['start-maxized']");
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/test/resource/drivers/win/geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("platform", Platform.WIN10);
			firefoxOptions.setProfile(profile);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			throw new IllegalArgumentException("Browser\"" + browser + "\" is not supported. ");
		}
		
	}

	/* Getter */
	public static WebDriver getDriver() {
		return driver;
	}
	

}