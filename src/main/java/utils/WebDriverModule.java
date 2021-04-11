package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverModule {

    protected WebDriver webDriver;

    public WebDriverModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean waitForElementToLoad(By locator, long timeoutInSeconds) {
        boolean result = true;
        try {
            new WebDriverWait(webDriver, timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            result = false;
        }
        return result;
    }

    public void typeByLocator(By locator, String text) {
        webDriver.findElement(locator).clear();
        webDriver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        webDriver.findElement(locator).click();
    }
}
