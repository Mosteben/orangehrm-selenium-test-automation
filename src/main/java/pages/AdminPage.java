package pages;

import org.openqa.selenium.*;

import java.time.Duration;

import static drivers.DriverSetup.waitForFiveSeconds;


public class AdminPage {
    //Driver
    protected WebDriver driver;

    //Locators
    public static final By ADMIN_IDLE = By.cssSelector("h6.oxd-text.oxd-text--h6.orangehrm-main-title");
    public static final By ADMIN_CORPORATE_BRANDING_DROP_DOWN_LIST =By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-item') and contains(text(), 'Corporate Branding')]");
    public static final By ADMIN_PRIMARY_COLOR=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    public static final By ADMIN_PRIMARY_COLOR_HEX=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/input[2]");
    public static final By ADMIN_CLIENT_LOGO=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div/div[2]/input");



    public AdminPage(WebDriver driver){
        this.driver = driver;
        driver.findElement(DashBoardLocators.ADMIN_MENU_ITEM).click();
    }

    public void editBranding(){
        waitForFiveSeconds();
        driver.findElement(AdminPage.ADMIN_CORPORATE_BRANDING_DROP_DOWN_LIST).click();
        waitForFiveSeconds();
        driver.findElement(AdminPage.ADMIN_PRIMARY_COLOR).click();
        waitForFiveSeconds();

        WebElement primaryColorInput = driver.findElement(ADMIN_PRIMARY_COLOR_HEX);
        primaryColorInput.click();
        //remove the existing color
        primaryColorInput.sendKeys(Keys.CONTROL + "a");  // Select all text
        primaryColorInput.sendKeys(Keys.DELETE);
        
        primaryColorInput.sendKeys("#cb24b7");
        driver.findElement(ADMIN_IDLE).click();
        WebElement clientLogoInput = driver.findElement(ADMIN_CLIENT_LOGO);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clientLogoInput.sendKeys("E:\\testing\\DEPI\\orangehrm-selenium-test-automation\\assets\\photos\\valid.svg");

    }




}
