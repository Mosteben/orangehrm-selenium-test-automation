package pages;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By USERNAME_FIELD = By.name("username");
    public static final By PASSWORD_FIELD = By.name("password");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    public static final By DASHBOARD_HEADER = By.xpath("//h6[text()='Dashboard']");
}
