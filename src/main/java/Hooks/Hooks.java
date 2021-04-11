package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverInstance;

public class Hooks extends WebDriverInstance {


    @Before
    public void setUpDriver() {
        createDriver();
    }

    @After
    public void tearDown() {
        stopSelenium();
    }

    public WebDriver getDriver() {
        return webDriver;
    }

}
