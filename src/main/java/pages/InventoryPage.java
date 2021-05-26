package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverModule;

import static org.testng.Assert.assertTrue;

public class InventoryPage extends WebDriverModule {

    private By cartIcon = By.id("shopping_cart_container");

    public InventoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void verifySuccessfulLogin() throws InterruptedException {
        assertTrue(waitForElementToLoad(cartIcon, 5), "Inventory page not loaded!");
        Thread.sleep(3000);
    }
}
