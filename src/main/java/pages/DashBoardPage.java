package pages;

import org.openqa.selenium.*;

import static java.nio.file.Files.copy;

public class DashBoardPage {
    //Driver
    protected WebDriver driver;


    //Locators
    //  public static final By AdminListInfo=By.className("oxd-userdropdown-name");
    public static final By AdminListInfo=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");
    public static final By About=By.xpath("//div[3]//li[1]//a[contains(text(),'About')]");
    public static final By Support=By.xpath("//ul/li/ul/li[2]/a");
    public static final By Logout=By.xpath("//ul/li/ul/li[3]/a");
    public static final By CompanyName=By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[1]/h6");

    public static final By ChangePassword=By.xpath("//ul/li/ul/li[4]/a");

    //Constructor
    public DashBoardPage(WebDriver driver){this.driver= driver;}

    //Actions
    public void getAdminInfo(){
        driver.findElement(AdminListInfo).click();
    }
    public void getAbout(){
        driver.findElement(About).click();
    }
    public void getCompanyName(){
        driver.findElement(CompanyName);
    }
    public PasswordPage changePassword(){
        driver.findElement(ChangePassword).click();
        return new PasswordPage(driver);
    }
}
