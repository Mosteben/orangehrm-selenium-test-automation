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
import pages.LoginPage;
import pages.RecruitmentPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RecruitmentTest {
    String expectedTitle = "OrangeHRM";
    WebDriver driver;
    LoginPage loginPage;
    LoginTest loginTest;
    RecruitmentPage VacanciesPage;
    RecruitmentPage CandidatesPage;


    @BeforeClass
    public void start() {
        driver = DriverSetup.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);
    }
    //LOGIN process
    @Test (testName = "testLogin", priority = 0)

    public void testLogin() {
      //  loginTest.testLogin();

        loginPage.enterUsername(TestData.USERNAME);
        loginPage.enterPassword(TestData.PASSWORD);
        driver=loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


    }


    @Test (testName = "add anew vacancy",priority = 8,dependsOnMethods = {"testLogin"})
    public void TestAddVacancy() {
        VacanciesPage  =new RecruitmentPage(driver);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        VacanciesPage.ClickOnRecruitmentModule();
        VacanciesPage.ClickOnVacanciesSubModule();
        VacanciesPage.ClickOnAddVacancyButton();
        VacanciesPage.TypeVacancyNameField("QA lead");
        VacanciesPage.TypeDescription("we need a new vacancy");
        VacanciesPage.TypeHiringManagerName("a");
        VacanciesPage.TypeHiringManagerNameChooice();
        VacanciesPage.TypeNumberOfPosition("4");
        VacanciesPage.ClickOnJobTitleDropDown();
        VacanciesPage.ClickOnJobTitleDropDownChoice();
        VacanciesPage.ClickOnSaveButton();
    }
    @Test (testName = "add anew candidates",priority = 10,dependsOnMethods = {"testLogin"})
    public void TestAddCandidate() {
        CandidatesPage  =new RecruitmentPage(driver);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        CandidatesPage.ClickOnRecruitmentModule();
        CandidatesPage.ClickOnCandidatesSubModule();
        CandidatesPage.ClickOnAddCandidateButton();
        CandidatesPage.TypeFirstName("Ali");
        CandidatesPage.TypeMiddleName("Alex");
        CandidatesPage.TypeLastName("Alex");
        CandidatesPage.ClickOnVacancyDropDown();
        CandidatesPage.ClickOnVacancyDropDownChoice();
        CandidatesPage.TypeEmail("admin@admin.com");
        CandidatesPage.TypeContactNumber("01030500206");
        CandidatesPage.ClickOnResume();
        CandidatesPage.UploadResume();
        CandidatesPage.TypeKaywords("BODY");
        CandidatesPage.TypeDateOfApplication("2024-10-5");
        CandidatesPage.TypeNote("HI IT IS ME");
        CandidatesPage.CeckConsent();
        CandidatesPage.ClickOnSave();





    }


    /*
    @AfterClass
    public void tearDown() {
        DriverSetup.quitDriver();
    }

*/


}
