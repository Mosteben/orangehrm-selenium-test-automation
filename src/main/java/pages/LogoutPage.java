package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;
    private LoginPageLocators locators;
    private LoginPageLocators LOCATORS;
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new LoginPageLocators();
    }



}
