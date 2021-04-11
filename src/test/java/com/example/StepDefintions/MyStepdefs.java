package com.example.StepDefintions;

import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class MyStepdefs {

    private final WebDriver webDriver;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;
    private Hooks hooks;


    public MyStepdefs(Hooks hooks) {
        this.hooks = hooks;
        this.webDriver = hooks.getDriver();
        this.loginPage = new LoginPage(webDriver);
        this.inventoryPage = new InventoryPage(webDriver);
    }

//    @Given("I open the site url \"([^\"]*)\"$")
//    public void iOpenTheSiteUrl(String url) {
//        webDriver.get(url);
//    }

    @When("I enter credentials and click login")
    public void iEnterCredentialsAndClickLogin() {
        loginPage.enterCredentials();
    }

    @Then("I'm logged in")
    public void iMLoggedIn() {
        inventoryPage.verifySuccessfulLogin();
    }

    @Given("I open the site url {string}")
    public void iOpenTheSiteUrl(String url) {
        webDriver.get(url);
    }
}
