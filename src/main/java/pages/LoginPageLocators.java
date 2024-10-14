package pages;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By USERNAME_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
    public static final By PASSWORD_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    public static final By DASHBOARD_HEADER = By.xpath("//h6[text()='Dashboard']");
}
