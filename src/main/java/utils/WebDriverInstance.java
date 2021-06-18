package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverInstance {
    protected WebDriver webDriver;

    public void createDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(configureBrowserType());
        caps.setCapability("resolution", "1920x1080");
        caps.setAcceptInsecureCerts(true);
        this.webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        this.webDriver.manage().window().maximize();
    }

    public void stopSelenium() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public String configureBrowserType() {
        if(System.getProperty("browser")==null || System.getProperty("browser").isBlank()) {
            return "chrome";
        }
        return System.getProperty("browser");
    }
}
