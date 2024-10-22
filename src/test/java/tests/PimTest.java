package tests;

import data.TestData;
import drivers.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.PIMPage;

import java.time.Duration;

public class PimTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private AdminPage adminPage;
    private PIMPage pimPage;

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
    public void testNavigateToPim() {
        pimPage = new PIMPage(driver);
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }



    @Test(dependsOnMethods = {"testNavigateToPim"})
    public void testSearchByEmployeeId() {
        pimPage.searchByEmployeeId("0295");
        pimPage.clickResetButton();

    }
    @Test(dependsOnMethods = {"testNavigateToPim"})
    public void testSelectEmployeeDropdown() {
        // Select the "Current Employees Only" option
        pimPage.selectEmployeeOption("Current Employees Only");

        // Verify the selected option
        String selectedOption = pimPage.getSelectedEmployeeOption();
        assertEquals(selectedOption, "-- Select --", "The selected employee option is incorrect.");
    }



    @AfterClass
    public void tearDown() {
       // DriverSetup.quitDriver();
    }
}
