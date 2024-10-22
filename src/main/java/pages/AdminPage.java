package pages;

import drivers.Common;
import org.openqa.selenium.*;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static drivers.DriverSetup.waitForFiveSeconds;


public class AdminPage {
    //Driver
    protected WebDriver driver;
    protected String violetColorHex="#cb24b7";

    //Locators
    public static final By ADMIN_IDLE = By.cssSelector("h6.oxd-text.oxd-text--h6.orangehrm-main-title");
    public static final By ADMIN_CORPORATE_BRANDING =By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-item') and contains(text(), 'Corporate Branding')]");
    public static final By ADMIN_PRIMARY_COLOR=By.xpath("//div[@style=\"background-color: rgb(255, 123, 29); opacity: 1; cursor: pointer;\"]");
    public static final By ADMIN_PRIMARY_COLOR_HEX=By.cssSelector("input[data-v-1f99f73c][data-v-2d1384ea]");
    public static final By ADMIN_CLIENT_LOGO=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div/div[2]/input");
    public static final By SYSTEM_USERS_USER_NAME=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    public static final By ADMIN_SUBMIT_BTN =By.xpath("//button[@type='submit']");
    public static final By ADMIN_ADD_NATIONALITY=By.className("oxd-button--medium");
    public static final By ADMIN_NATIONALITITES =By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-item') and contains(text(), 'Nationalities')]");
    public static final By ADMIN_NATIONALITY_NAME=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");

    public AdminPage(WebDriver driver){
        this.driver = driver;
        driver.findElement(DashBoardLocators.ADMIN_MENU_ITEM).click();
    }

    public void editBranding(){
        waitForFiveSeconds(5);
        Common.buttonClick(driver,ADMIN_CORPORATE_BRANDING);
        waitForFiveSeconds(5);
        Common.buttonClick(driver,ADMIN_PRIMARY_COLOR);
        WebElement primaryColorInput = Common.buttonClick(driver,ADMIN_PRIMARY_COLOR_HEX);
        //remove the existing color
        primaryColorInput.sendKeys(Keys.CONTROL + "a");  // Select all text
        primaryColorInput.sendKeys(Keys.DELETE);
        primaryColorInput.sendKeys(violetColorHex);

        Common.buttonClick(driver,ADMIN_IDLE).click();
        WebElement clientLogoInput = driver.findElement(ADMIN_CLIENT_LOGO);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clientLogoInput.sendKeys("E:\\testing\\DEPI\\orangehrm-selenium-test-automation\\assets\\photos\\valid.svg");
    }

    public void searchForUser(){
        WebElement userNameInput=Common.buttonClick(driver,SYSTEM_USERS_USER_NAME);
        userNameInput.sendKeys(Keys.CONTROL + "a");
        userNameInput.sendKeys("Admin");
        Common.buttonClick(driver, ADMIN_SUBMIT_BTN);
    }
    public void editNationality(){
        waitForFiveSeconds(5);
        Common.buttonClick(driver,ADMIN_NATIONALITITES);
        Common.buttonClick(driver,ADMIN_ADD_NATIONALITY);
        WebElement nationalityNameInput=Common.buttonClick(driver,ADMIN_NATIONALITY_NAME);
        nationalityNameInput.sendKeys("Egyptian");
        Common.buttonClick(driver, ADMIN_SUBMIT_BTN);
    }



}
