package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private LoginPageLocators locators;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new LoginPageLocators();
    }

    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.USERNAME_FIELD));
        driver.findElement(locators.USERNAME_FIELD).sendKeys(username);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.PASSWORD_FIELD));
        driver.findElement(locators.PASSWORD_FIELD).sendKeys(password);
    }

    public WebDriver clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locators.LOGIN_BUTTON));
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
        return driver;
    }

    public By getDashboardElementLocator() {
        return locators.DASHBOARD_HEADER;
    }
}
