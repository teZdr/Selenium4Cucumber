package com.example.glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.RuntimeSystemProperties;
import utils.WebDriverInstance;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks extends WebDriverInstance {

    private static final Logger logger = Logger.getLogger(Hooks.class.getName());
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @Before
    public void setupBrowser() {
        try {
            String environment = RuntimeSystemProperties.ENVIRONMENT;
            String browser = RuntimeSystemProperties.BROWSER;
            String hubUrl = RuntimeSystemProperties.LOCAL_SELENIUM_HUB;

            startBrowser(environment, hubUrl, browser);
            driverThreadLocal.set(getWebDriver());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to create WebDriver instance: " + e.getMessage(), e);
            throw new RuntimeException("Failed to create WebDriver instance.", e);
        }
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @After
    public void tearDown() {
        try {
            if (getDriver() != null) {
                getDriver().quit();
                driverThreadLocal.remove();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to quit WebDriver instance: " + e.getMessage(), e);
        }
    }
}