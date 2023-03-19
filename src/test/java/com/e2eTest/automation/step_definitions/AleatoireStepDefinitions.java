package com.e2eTest.automation.step_definitions;


import org.openqa.selenium.WebDriver;


import com.e2eTest.automation.page_objects.AleatoirePageObj;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Setup;
import com.e2eTest.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AleatoireStepDefinitions {
	
	public AleatoirePageObj aleatoirePageObj;
	public SeleniumUtils seleniumUtils;
	public ConfigFileReader configFileReader;
	public Validations validations;
	private WebDriver driver;
	public AleatoireStepDefinitions() {
		
		aleatoirePageObj = new AleatoirePageObj();
		seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		validations = new Validations();
		this.driver = Setup.getDriver();
	}
	
	@Given("J accede à l application bouletcorp")
	public void jAccedeÀLApplicationBouletcorp() {
		seleniumUtils.get(configFileReader.getProperties("bouletCorp.url"));
	}
	@When("Je clique sur le bouton Aleatoire")
	public void jeCliqueSurLeBoutonAleatoire() {
		seleniumUtils.click(AleatoirePageObj.aleatoireBtn);
	}


@Then("La page change")
public void laPageChange() {
	System.out.println(configFileReader.getProperties("bouletCorp.url")+" is different "+ SeleniumUtils.getCurrentUrl(driver) );
	validations.assertNotEquals(configFileReader.getProperties("bouletCorp.url"), SeleniumUtils.getCurrentUrl(driver));
}
	@Then("Je trouve les widgets facebook twitter et tumblr")
	public void jeTrouveLesWidgetsFacebookTwitterEtTumblr() {
		validations.isElementDisplayed(AleatoirePageObj.facebookWidget);
		validations.isElementDisplayed(AleatoirePageObj.twitterWidget);
		validations.isElementDisplayed(AleatoirePageObj.tumblrWidget);
	}




}
