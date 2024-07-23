package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserOptions {

    /**
     * Gets the ChromeOptions with the required configurations.
     *
     * @return ChromeOptions object with specified settings
     */
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        // Add more Chrome specific options here if needed
        return options;
    }

    /**
     * Gets the FirefoxOptions with the required configurations.
     *
     * @return FirefoxOptions object with specified settings
     */
    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--start-maximized"); // sometimes unreliable
        options.setAcceptInsecureCerts(true);
        // Add more Firefox specific options here if needed
        return options;
    }

    /**
     * Gets the SafariOptions with the required configurations.
     *
     * @return SafariOptions object with specified settings
     */
    public static SafariOptions getSafariOptions() {
        // Safari doesn't support '--start-maximized', you may need to resize the window manually in the tests
        // options.setCapability("safari.cleanSession", true); // This might cause issues
        return new SafariOptions();
    }

    /**
     * Gets the EdgeOptions with the required configurations.
     *
     * @return EdgeOptions object with specified settings
     */
    public static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        // Add more Edge specific options here if needed
        return options;
    }

    /**
     * Gets the DesiredCapabilities for the specified browser type.
     *
     * @param browserType the browser type (e.g., "chrome", "firefox", "safari", "edge")
     * @return DesiredCapabilities object with specified settings
     */
    public static DesiredCapabilities getDesiredCapabilities(String browserType) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browserType);
        caps.setAcceptInsecureCerts(true);
        // Add more general capabilities here if needed
        return caps;
    }
}