package com.e2eTest.automation.utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class BasePage1 {
	/** Log **/
	//protected static Logger log = LogManager.getLogger();

    protected  WebDriver driver;

    public BasePage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}