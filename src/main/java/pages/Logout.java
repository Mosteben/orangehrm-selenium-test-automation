package pages;

import org.openqa.selenium.WebDriver;

public class Logout {
    private WebDriver driver;
    private LogoutPageLocators locators;


    private LogoutPage logoutPage;


    public void Logout(WebDriver driver) {
        this.driver = driver;
        this.locators = new LogoutPageLocators();
    }
}
