package com.example.glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverInstance;

import java.net.MalformedURLException;

public class Hooks extends WebDriverInstance {


    @Before
    public void setupBrowser() throws MalformedURLException {
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
