package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class leave {
    protected WebDriver driver;
//locator
    public static final By leave_button = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a");
    public leave(WebDriver driver){
        this.driver = driver;
        driver.findElement(leave_button).click();
    }
}
