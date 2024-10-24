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
import pages.PIMPage;
import pages.leave;
import pages.LoginPage;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static java.nio.file.Files.copy;

public class Leavetest {
    private WebDriver driver;
    private LoginPage loginPage;
    private leave leave ;

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
    @Test(dependsOnMethods = {"testLogin"})
    public void testNavigateToleave() throws IOException {
        leave= new leave(driver);
       // leave.setLeave_title();
       String expectedTitle = "OrangeHRM";
       String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
       // leave.setLeave_Apply();
//       leave.setLeave_comment("Mysoun");

    }

   // @AfterClass
    //public void tearDown() {
       // DriverSetup.quitDriver();
    //}

}

