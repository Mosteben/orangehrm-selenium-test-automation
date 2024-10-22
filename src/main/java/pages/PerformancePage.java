package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.nio.file.Files.copy;
public class PerformancePage {
    //Driver
    protected WebDriver driver;
    //Locators
    public static final By MyActions=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/p");
    //   public static final By Perform=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/p[contains(text(),'(1) Pending Self Review')]");
    public static final By Perform=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a/span");
    //   public static final By Perform=By.xpath("//div[@class='orangehrm-todo-list-item'][1]/p");
//public static final By Configure=By.xpath("//li[1]/span[contains(text(),'Configure')]");
    public static final By Configure=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span[contains(text(),'Configure ')]");
    //public static final By Configure=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span");
    public static final By MenueConfigure=By.className("oxd-dropdown-menu");
    public static final By KPI=By.xpath("//ul/li[1]/a[contains(text(),'KPIs')]");

    public PerformancePage(WebDriver driver){this.driver= driver;}

    public void getMyActions(){
        driver.findElement(MyActions);
    }
    public void getPerformance(){
        driver.findElement(Perform).click();
    }
    public void getConfigure(){
        WebElement configureElement = driver.findElement(Configure);
        configureElement.click();
    }
    public searchKpiPage getKPIs(){
        driver.findElement(Configure).click();
        driver.findElement(MenueConfigure).click();
        driver.findElement(KPI).click();
        return new searchKpiPage(driver);
    }
}
