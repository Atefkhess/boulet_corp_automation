package com.e2eTest.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



import com.e2eTest.automation.utils.Setup;

public class AleatoirePageObj {

		/* Retrieve Element */
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//div[@id='tabvanilla']//a[contains(text(),'Aléatoire')]")
		public static WebElement aleatoireBtn;

		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//img[@src='https://bouletcorp.com/wp-content/plugins/socialize-this/widgets/alteredicons/facebook.png']")
		public static WebElement facebookWidget;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//img[@src='https://bouletcorp.com/wp-content/plugins/socialize-this/widgets/alteredicons/twitter.png']")
		public static WebElement twitterWidget;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//img[@src='https://bouletcorp.com/wp-content/themes/bouletcorp/images/icons/Tumblr.png']")
		public static WebElement tumblrWidget;


		public AleatoirePageObj() {
			PageFactory.initElements(Setup.getDriver(), this);
		}
	}
