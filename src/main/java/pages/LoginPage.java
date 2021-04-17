package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverModule;

public class LoginPage extends WebDriverModule {

    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void enterCredentials() {
        waitForElementToLoad(userName, 5);
        typeByLocator(userName, "standard_user");
        typeByLocator(password, "secret_sauce");
        click(loginButton);
    }


}
