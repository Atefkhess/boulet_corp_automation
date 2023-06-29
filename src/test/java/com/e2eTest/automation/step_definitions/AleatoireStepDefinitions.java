package com.e2eTest.automation.step_definitions;

import org.junit.Assert;

import com.e2eTest.automation.page_objects.AleatoirePageObj;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AleatoireStepDefinitions {

	public AleatoirePageObj aleatoirePageObj;
	public Utils utils;
	public ConfigFileReader configFileReader;
	String properties;

	public AleatoireStepDefinitions() {

		aleatoirePageObj = new AleatoirePageObj();
		utils = new Utils();
		this.configFileReader = new ConfigFileReader();
		properties = configFileReader.getProperties("bouletCorp.url");
	}

	@Given("J accede à l application bouletcorp")
	public void jAccedeÀLApplicationBouletcorp() {
		utils.get(properties);
	}

	@When("Je clique sur le bouton Aleatoire")
	public void jeCliqueSurLeBoutonAleatoire() {
		utils.click(AleatoirePageObj.aleatoireBtn);
	}

	@Then("La page change")
	public void laPageChange() {
		// System.out.println(configFileReader.getProperties("bouletCorp.url")+" is
		// different "+ SeleniumUtils.getCurrentUrl(driver) );
		utils.assertNotEquals(properties, utils.getCurrentUrl());
		// utils.checkUrlChanged(properties);
	}

	@Then("Je trouve les widgets facebook twitter et tumblr")
	public void jeTrouveLesWidgetsFacebookTwitterEtTumblr() {
		Boolean res = utils.isElementDisplayed(AleatoirePageObj.facebookWidget);
		Assert.assertTrue(res);
		Boolean res1 = utils.isElementDisplayed(AleatoirePageObj.twitterWidget);
		Assert.assertTrue(res1);
		Boolean res2 = utils.isElementDisplayed(AleatoirePageObj.tumblrWidget);
		Assert.assertTrue(res2);
	}
}
