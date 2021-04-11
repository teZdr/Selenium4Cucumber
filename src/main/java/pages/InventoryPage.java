package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverModule;

public class InventoryPage extends WebDriverModule {

    private By cartIcon = By.id("shopping_cart_container");

    public InventoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void verifySuccessfulLogin() {
        waitForElementToLoad(cartIcon, 5);
//        assertTrue(webDriver.findElement(cartIcon).isDisplayed(), "Inventory page not loaded!");
    }
}
