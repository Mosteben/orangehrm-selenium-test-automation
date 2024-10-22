package pages;
import data.TestData;
import drivers.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import static org.testng.Assert.*;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.PIMPage;
import java.time.Duration;
public class PasswordPage {
    //Driver
    protected WebDriver driver;
    private WebDriverWait wait;
    //Locators
    //  public static final By AdminListInfo=By.className("oxd-userdropdown-name");
    public static final By CurrentPassword=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/input");
    public static final By NewPassword=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    public static final By ConfirmPassword=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    public static final By SaveButton=By.xpath("//div[3]/button[2]");

    //Constructor
    public PasswordPage(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCurrentPassword(String currentPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CurrentPassword));
        driver.findElement(CurrentPassword).sendKeys(currentPassword);
    }
    public void enterNewPassword(String newPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(NewPassword));
        driver.findElement(NewPassword).sendKeys(newPassword);
    }
    public void enterConfirmPassword(String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPassword));
        driver.findElement(ConfirmPassword).sendKeys(confirmPassword);
    }
    public WebDriver clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        driver.findElement(SaveButton).click();
        return driver;
    }
    public String getMessage(){
        WebElement employeeIdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"oxd-toaster_1\"]")));
        return employeeIdInput.getAttribute("textContent");
    }
}
