package drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common {
    Common(){}
    public static WebElement buttonClick(WebDriver myDriver, By myLocator)
    {
        myDriver.findElement(myLocator).click();
        return myDriver.findElement(myLocator);
    }
}
