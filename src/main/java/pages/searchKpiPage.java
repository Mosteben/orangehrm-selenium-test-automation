package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class searchKpiPage {
    //Driver
    protected WebDriver driver;
    //Locators
    public static final By jobdownlist=By.className("oxd-select-text-input");
    //    public static final By searchdata=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div/div/div[2]/div/div/div[1]");
    public static final By searchbutton=By.xpath("//form/div[2]/button[2]");
    public static final By resultSearch=By.xpath("//div[2]/div/span[1]");

    public searchKpiPage(WebDriver driver){this.driver= driver;}

    //    public void searchJob(){
//        driver.findElement(jobdownlist).click();
//    }
    public void selectFromDropdown(String valueToSelect) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the dropdown is visible
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobdownlist));

        // Create a Select object to interact with the dropdown
        Select dropdown = new Select(dropdownElement);

        // Select by visible text
        dropdown.selectByVisibleText(valueToSelect);

        // Alternatively, you could select by index or value
        // dropdown.selectByIndex(1); // Selects the second item
        // dropdown.selectByValue("valueAttribute"); // Select by the value attribute of the option
    }
    public void ClickSearchButton() {
        driver.findElement(searchbutton).click();
        driver.findElement(resultSearch);
    }

}
