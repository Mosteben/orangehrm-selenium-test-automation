package pages;

import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RecruitmentPage {
    //1- by locators
    //2- create elements
    //3- constructors
    //4- create methods
     WebDriver driver;
                                      //locators of main modules
    //Recruitment module locator
    public   By RECRUITMENT_PAGE_TITLE = By.xpath("//span[text()='Recruitment']");

    //VACANCIES button sub-module locator
    public   By VACANCIES_PAGE = By.xpath("//a[text()='Vacancies']");

    //CANDIDATES button sub-module locator
    public   By CANDIDATES_PAGE = By.xpath("//a[text()='Candidates']");

                                  //locators of vacancies sub-module
    //LOCATOR of button that add new vacancy
    public   By ADD_VACANCY_BUTTON = By.xpath("//div[@class='orangehrm-header-container']//button[@class='oxd-button oxd-button--medium oxd-button--secondary' and contains(., 'Add')]\n");

    //LOCATOR of VACANCY NAME text field in add vacancy page
    public   By VACANCY_NAME_FIELD = By.xpath("//label[text()='Vacancy Name']/following::input[@class='oxd-input oxd-input--active']");

    public   By job_title_DROP_DOWN = By.xpath("//div[@class='oxd-select-text--after']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']\n");

    //LOCATOR of JOB TITLE  drop down list in add vacancy page
    public   By job_title_DROP_CHOOICE = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div[3]");

    //LOCATOR of DESCRIPTION  field in add vacancy page
    public   By DESCRIPTION = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");

    //LOCATORS of HIRINGMANGER  field in add vacancy page
    public   By HIRINGMANGER = By.xpath("//input[@placeholder='Type for hints...']");
    public   By HIRINGMANGERCHOOICE = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div/div[2]/div/div[2]/div[2]");

    //LOCATOR of NumberOfPositions  field in add vacancy page
    public   By NUMBEROFPOSITION = By.xpath("//label[text()='Number of Positions']/following::input[@class='oxd-input oxd-input--active']");

    //LOCATOR of SaveButton  field in add vacancy page
    By SAVEBUTTON = By.xpath("//div[@class='oxd-form-actions']//button[@type='submit' and contains(., 'Save')]");
                                   //candidates sub-module locators

    By ADD_CANDIDATE_BUTTON = By.xpath("//div[@class='orangehrm-header-container']//button[@type='button' and contains(., 'Add')]");
    By  FIRST_NAME =By.xpath("//input[@name='firstName']");
    By  MIDDLE_NAME =By.xpath("//input[@name='middleName']");
    By  LAST_NAME =By.xpath("//input[@name='lastName']");

    By  VACANCY_DROPDOWN =By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    By  VACANCY_DROPDOWN_CHOOICE =By.xpath("//div[@class='oxd-select-option' and .//span[text()='Sales Representative']]");
    By   EMAIL_FEILD = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//label[text()='Email']/parent::div/following-sibling::div//input[@class='oxd-input oxd-input--active']");
    By  CONTACT_NUMBER = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//label[text()='Contact Number']/parent::div/following-sibling::div//input[@class='oxd-input oxd-input--active']");
    By  CLICK_ON_RESUME = By.xpath("//div[@class='oxd-file-button']");
    By  RESUME =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div/div/div/div[2]/input");

    By KAYWORDS =By.xpath("//input[@placeholder='Enter comma seperated words...']");
    By DATE_OF_APPLICATION =By.xpath("//input[@placeholder='yyyy-dd-mm']");
    By CHOOSE_dATE =By.xpath("//div[@class='oxd-calendar-date' and text()='1']");

    By NOTE =By.xpath("//textarea[@placeholder='Type here']");
    By ConsenttokeepdataCheckBox=By.xpath("//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']");
    By SAVE_CANDIDATE_BUTTON =By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    /*
    // Create Elements
     WebElement RecruitmentModuleButton= driver.findElement(RECRUITMENT_PAGE_TITLE);
     WebElement VacancySubModuleButton= driver.findElement(VACANCIES_PAGE);
     WebElement CandidatesSubModuleButton= driver.findElement(CANDIDATES_PAGE);
     WebElement AddVacancyButton= driver.findElement(ADD_VACANCY_BUTTON);
     WebElement VacancyNameField= driver.findElement(VACANCY_NAME_FIELD);
     WebElement JobTitleField= driver.findElement(job_title_DROP_DOWN);
     WebElement DescriptionField= driver.findElement(DESCRIPTION);
     WebElement HIRINGMANGERField= driver.findElement(HIRINGMANGER);
     WebElement NumberOfPositionField= driver.findElement(NUMBEROFPOSITION);
*/


    //open Recruitment module
    public RecruitmentPage(WebDriver driver){
        this.driver = driver;
    }
                           //Actions OF Vacancy page
    public void ClickOnRecruitmentModule(){

        driver.findElement(RECRUITMENT_PAGE_TITLE).click();
        //VacancySubModuleButton.click();
    }
    //click on vacancies sub-module button
    public void ClickOnVacanciesSubModule(){
        driver.findElement(VACANCIES_PAGE).click();

    }
    //click on candidates sub-module button

    public void ClickOnAddVacancyButton(){
        driver.findElement(ADD_VACANCY_BUTTON).click();
    }
    public void TypeVacancyNameField(String vacancyName){
        driver.findElement(VACANCY_NAME_FIELD).sendKeys(vacancyName);
       // VacancyNameField.sendKeys(vacancyName);
    }
    public void ClickOnJobTitleDropDown(){
        driver.findElement(job_title_DROP_DOWN).click();
    }
    public void ClickOnJobTitleDropDownChoice(){
        driver.findElement(job_title_DROP_CHOOICE).click();
    }

    public void TypeDescription(String Description){
        driver.findElement(DESCRIPTION).sendKeys(Description);
    }
    public void TypeHiringManagerName(String HiringManagerName){
        driver.findElement(HIRINGMANGER).sendKeys(HiringManagerName);
    }
    public void TypeHiringManagerNameChooice(){
        driver.findElement(HIRINGMANGERCHOOICE).click();
    }
    public void TypeNumberOfPosition(String NumberOfPosition){
        driver.findElement(NUMBEROFPOSITION).sendKeys(NumberOfPosition);
    }
    public void ClickOnSaveButton(){
        driver.findElement(SAVEBUTTON).click();
    }
            //actions of candidates page
            //click on candidates sub-module button
     public void ClickOnCandidatesSubModule(){

         driver.findElement(CANDIDATES_PAGE).click();
    }
    public void ClickOnAddCandidateButton(){
        driver.findElement(ADD_CANDIDATE_BUTTON).click();
    }
    public void TypeFirstName(String FirstName){
        driver.findElement(FIRST_NAME).sendKeys(FirstName);
    }
    public void TypeMiddleName(String MiddleName){
        driver.findElement(MIDDLE_NAME).sendKeys(MiddleName);
    }
    public void TypeLastName(String LastName){
        driver.findElement(LAST_NAME).sendKeys(LastName);
    }
    public void ClickOnVacancyDropDown(){
        driver.findElement(VACANCY_DROPDOWN).click();
    }
    public void ClickOnVacancyDropDownChoice(){
        driver.findElement(VACANCY_DROPDOWN_CHOOICE).click();
    }
    public void TypeEmail(String Email){
        driver.findElement(EMAIL_FEILD).sendKeys(Email);
    }
    public void TypeContactNumber(String ContactNumber){
        driver.findElement(CONTACT_NUMBER).sendKeys(ContactNumber);
    }
    public void ClickOnResume(){
        driver.findElement(CLICK_ON_RESUME).click();
    }
    public void UploadResume(){
        driver.findElement(RESUME).sendKeys("E:\\TESTING\\abdallah__CV.pdf");
    }
    public void TypeKaywords(String Kaywords){
        driver.findElement(KAYWORDS).sendKeys(Kaywords);
    }
    public void TypeDateOfApplication(String DateOfApplication){
        driver.findElement(DATE_OF_APPLICATION).click();
        driver.findElement(CHOOSE_dATE).click();
    }
    public void TypeNote(String Note){
        driver.findElement(NOTE).sendKeys(Note);
    }
    public void CeckConsent(){
        driver.findElement(ConsenttokeepdataCheckBox).click();
    }
    public void ClickOnSave(){
        driver.findElement(SAVE_CANDIDATE_BUTTON).click();
    }

}
