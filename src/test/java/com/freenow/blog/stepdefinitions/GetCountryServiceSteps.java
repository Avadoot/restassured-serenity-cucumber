package com.freenow.blog.stepdefinitions;

import com.freenow.blog.posts.CountryInfoServiceActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.xml.XmlPath;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class GetCountryServiceSteps {

    @Steps
    CountryInfoServiceActions currencyPostActions;

    public static XmlPath xmlPath;

    @When("I call the get currency for country endpoint")
    public void iCallTheGetCurrencyForCountryEndpoint() throws IOException {
        currencyPostActions.getCurrency();
    }

    @Then("I should see valid currency for country in response")
    public void iShouldSeeValidCurrencyForCountryInResponse() {
        xmlPath = new XmlPath(lastResponse().asString());
        String currencyName = xmlPath.getString("m:sName");
        Assert.assertEquals("Currency for country not matching",
                "USDDollars", currencyName);
    }

    @When("I call the get phone code for country endpoint")
    public void iCallTheGetPhoneCodeForCountryEndpoint() throws IOException {
        currencyPostActions.getPhoneCode();
    }

    @Then("I should see valid phone code for country in response")
    public void iShouldSeeValidPhoneCodeForCountryInResponse() {
        xmlPath = new XmlPath(lastResponse().asString());
        String phoneCode = xmlPath.getString("m:CountryIntPhoneCodeResult");
        Assert.assertEquals("Phone code for country not matching",
                "91", phoneCode);
    }

    @When("I call the get capital city for country endpoint")
    public void iCallTheGetCapitalCityForCountryEndpoint() throws IOException {
        currencyPostActions.getCapitalCity();
    }

    @Then("I should see valid capital city for country in response")
    public void iShouldSeeValidCapitalCityForCountryInResponse() {
        xmlPath = new XmlPath(lastResponse().asString());
        String capitalCity = xmlPath.getString("m:CapitalCityResult");
        Assert.assertEquals("Capital city for country not matching",
                "Washington", capitalCity);
    }
}
