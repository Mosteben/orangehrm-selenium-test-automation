package tests;
import data.TestData;
import drivers.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.PasswordPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static java.nio.file.Files.copy;
public class DashBoardTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashBoardPage dashboardPage;
    private LoginTest loginTest;
    private PasswordPage passwordPage;


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
        driver = loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testAbout() throws IOException {
        dashboardPage = new DashBoardPage(driver);
        dashboardPage.getAdminInfo();
        dashboardPage.getAbout();
        //dashboardPage.getCompanyName();
        // Assert.assertTrue(dashboardPage.getCompanyName().isDisplayed(), "CompanyName is Found!");

        // Take a screenshot after login
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture screenshot in bytes for reporting (if needed)
        byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

        // Capture and save the screenshot to a file
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("E:\\Hana_2\\MyScience\\Testing\\orangehrm-selenium-test-automation-main/about.png");

        // Copy the screenshot file to the destination
        copy(screenshotFile.toPath(), destinationFile.toPath());
    }
    @Test(dependsOnMethods = {"testLogin"})
    public void testChangePassword() throws IOException {
        // Initialize dashboard page and perform actions to get to change password section
        dashboardPage = new DashBoardPage(driver);
        dashboardPage.getAdminInfo();
        dashboardPage.changePassword();

        // Initialize the password page and fill out the password form
        passwordPage = new PasswordPage(driver);
        passwordPage.enterCurrentPassword(TestData.PASSWORD);
        passwordPage.enterNewPassword(TestData.NewPassword);
        passwordPage.enterConfirmPassword(TestData.NewPassword);

        // Click the save button and wait for the confirmation message
        passwordPage.clickSaveButton();

        // Verify that the success message is displayed
        String expectedTitle = "Success Successfully Saved";
        String actualTitle = passwordPage.getMessage();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterClass
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
