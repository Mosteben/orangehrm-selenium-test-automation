package tests;
import data.TestData;
import drivers.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static java.nio.file.Files.copy;

public class PerformanceTest
{
    private WebDriver driver;
    private LoginPage loginPage;
    private PerformancePage performancePage;

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
        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test(dependsOnMethods = {"testLogin"})
    public void checkSearchJob() throws IOException{
        performancePage = new PerformancePage(driver);
        performancePage.getMyActions();
        performancePage.getPerformance();
        // performancePage.getConfigure();
        // performancePage.getKPIs();

//        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture screenshot in bytes for reporting (if needed)
//        byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
//
//        // Capture and save the screenshot to a file
//        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File("./performance.png");
//
//        // Copy the screenshot file to the destination
//        copy(screenshotFile.toPath(), destinationFile.toPath());
    }


    @AfterClass
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
