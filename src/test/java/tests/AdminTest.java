package tests;

import data.TestData;
import drivers.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

import java.time.Duration;

public class AdminTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private AdminPage adminPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetup.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.enterUsername(TestData.USERNAME);
        loginPage.enterPassword(TestData.PASSWORD);
        driver=loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }
    @Test (dependsOnMethods = {"testLogin"})
    public void testAdmin() {
        adminPage=new AdminPage(driver);
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }
    @Test(dependsOnMethods = {"testAdmin"})
    public void addUser() {
       //adminPage.editBranding();
        //DriverSetup.waitForFiveSeconds(5);
        //adminPage.searchForUser();
        adminPage.editNationality();

    }

    @AfterClass
    public void tearDown() {
        //DriverSetup.quitDriver();
    }
}
