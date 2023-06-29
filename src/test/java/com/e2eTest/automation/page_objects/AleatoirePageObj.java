package com.e2eTest.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTest.automation.utils.BasePage;
import com.e2eTest.automation.utils.Setup;

public class AleatoirePageObj extends BasePage {

		/* Retrieve Element */
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//div[@id='tabvanilla']//a[contains(text(),'Aléatoire')]")
		public static WebElement aleatoireBtn;

		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//img[@title='Twitter']\r\n")
		public static WebElement facebookWidget;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//img[@title='Twitter']\r\n")
		public static WebElement twitterWidget;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//a[@title='Share on Tumblr']\r\n")
		public static WebElement tumblrWidget;


		public AleatoirePageObj() {
			super(Setup.getDriver());
		}
	}
