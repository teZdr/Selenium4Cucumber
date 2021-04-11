package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInstance {
    protected WebDriver webDriver;

    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
    }

    public void stopSelenium() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
