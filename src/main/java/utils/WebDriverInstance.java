package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverInstance {
    private static final Logger logger = Logger.getLogger(WebDriverInstance.class.getName());
    protected WebDriver webDriver;

    /**
     * Creates a new WebDriver instance based on the specified capabilities.
     */
    public void createDriver() {
        String hubUrl = System.getProperty("hubUrl");
        if (hubUrl == null || hubUrl.isBlank()) {
            // Use Selenium Manager
            createLocalDriver();
        } else {
            // Use Selenium Hub
            createRemoteDriver(hubUrl);
        }
    }

    /**
     * Creates a local WebDriver instance using Selenium Manager.
     */
    private void createLocalDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            this.webDriver = new ChromeDriver(options);
            logger.info("Local WebDriver created and maximized successfully using Selenium Manager.");
        } catch (WebDriverException e) {
            logger.log(Level.SEVERE, "Failed to create local WebDriver using Selenium Manager.", e);
            throw new RuntimeException("Failed to create local WebDriver.", e);
        }
    }

    /**
     * Creates a remote WebDriver instance with the specified hub URL.
     *
     * @param hubUrl the URL of the Selenium hub
     */
    private void createRemoteDriver(String hubUrl) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(configureBrowserType());
            caps.setAcceptInsecureCerts(true);

            ChromeOptions options = new ChromeOptions();
            options.merge(caps);
            options.addArguments("--start-maximized");

            this.webDriver = new RemoteWebDriver(new URL(hubUrl), options);
            this.webDriver.manage().window().maximize();
            logger.info("Remote WebDriver created and maximized successfully.");
        } catch (MalformedURLException e) {
            logger.log(Level.SEVERE, "Malformed URL for WebDriver hub: " + hubUrl, e);
            throw new RuntimeException("Failed to create remote WebDriver due to malformed URL: " + hubUrl, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to create remote WebDriver.", e);
            throw new RuntimeException("Failed to create remote WebDriver.", e);
        }
    }

    /**
     * Stops the WebDriver instance if it is running.
     */
    public void stopSelenium() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
            logger.info("WebDriver stopped successfully.");
        }
    }

    /**
     * Configures the browser type based on system properties.
     *
     * @return the browser type
     */
    public String configureBrowserType() {
        String browser = System.getProperty("browser");
        return (browser == null || browser.isBlank()) ? "chrome" : browser;
    }
}