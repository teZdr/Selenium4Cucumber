package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverInstance {
    private static final Logger logger = Logger.getLogger(WebDriverInstance.class.getName());
    protected WebDriver webDriver;

    /**
     * Starts the browser based on the environment, hub URL, and browser type.
     *
     * @param environment the environment (localDriver or remote)
     * @param hubUrl      the URL of the Selenium hub
     * @param browser     the browser type (e.g., "chrome", "firefox", "safari", "edge")
     */
    public void startBrowser(String environment, String hubUrl, String browser) {
        if (environment.equalsIgnoreCase("localDriver")) {
            createLocalDriver(browser);
        } else {
            createRemoteDriver(hubUrl, browser);
        }
    }

    /**
     * Creates a local WebDriver instance using Selenium Manager.
     *
     * @param browserType the browser type (e.g., "chrome", "firefox", "safari", "edge")
     */
    private void createLocalDriver(String browserType) {
        try {
            switch (browserType.toLowerCase()) {
                case "chrome":
                    this.webDriver = new ChromeDriver(BrowserOptions.getChromeOptions());
                    break;
                case "firefox":
                    this.webDriver = new FirefoxDriver(BrowserOptions.getFirefoxOptions());
                    this.webDriver.manage().window().maximize();
                    break;
                case "safari":
                    this.webDriver = new SafariDriver(BrowserOptions.getSafariOptions());
                    break;
                case "edge":
                    this.webDriver = new EdgeDriver(BrowserOptions.getEdgeOptions());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser type: " + browserType);
            }
            logger.info("Local WebDriver created and maximized successfully using Selenium Manager.");
        } catch (WebDriverException e) {
            logger.log(Level.SEVERE, "Failed to create local WebDriver using Selenium Manager.", e);
            throw new RuntimeException("Failed to create local WebDriver.", e);
        }
    }

    /**
     * Creates a remote WebDriver instance with the specified hub URL.
     *
     * @param hubUrl      the URL of the Selenium hub
     * @param browserType the browser type (e.g., "chrome", "firefox", "safari", "edge")
     */
    private void createRemoteDriver(String hubUrl, String browserType) {
        try {
            DesiredCapabilities caps = BrowserOptions.getDesiredCapabilities(browserType);

            switch (browserType.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = BrowserOptions.getChromeOptions();
                    chromeOptions.merge(caps);
                    this.webDriver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = BrowserOptions.getFirefoxOptions();
                    firefoxOptions.merge(caps);
                    this.webDriver = new RemoteWebDriver(new URL(hubUrl), firefoxOptions);
                    this.webDriver.manage().window().maximize();
                    break;
                case "safari":
                    SafariOptions safariOptions = BrowserOptions.getSafariOptions();
                    safariOptions.merge(caps);
                    this.webDriver = new RemoteWebDriver(new URL(hubUrl), safariOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = BrowserOptions.getEdgeOptions();
                    edgeOptions.merge(caps);
                    this.webDriver = new RemoteWebDriver(new URL(hubUrl), edgeOptions);
                    break;
                default:
                    throw new RuntimeException("Unsupported browser type: " + browserType);
            }

        } catch (MalformedURLException e) {
            logger.log(Level.SEVERE, "Malformed URL for WebDriver hub: " + hubUrl, e);
            throw new RuntimeException("Failed to create remote WebDriver due to malformed URL: " + hubUrl, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to create remote WebDriver.", e);
            throw new RuntimeException("Failed to create remote WebDriver.", e);
        }
    }

    /**
     * Gets the current WebDriver instance.
     *
     * @return the WebDriver instance
     */
    public WebDriver getWebDriver() {
        return this.webDriver;
    }
}