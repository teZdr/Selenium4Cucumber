package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverInstance;

public class Hooks extends WebDriverInstance {


    private String scenarioName = "";

    @Before
    public void setupBrowser() {
        createDriver();
    }



    public WebDriver getDriver() {
        return webDriver;
    }

    @After
    public void tearDown() {
        stopSelenium();
    }
}
