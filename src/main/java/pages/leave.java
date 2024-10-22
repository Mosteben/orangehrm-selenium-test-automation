package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class leave {
    protected WebDriver driver;
//locator
    public static final By leave_button = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a");
   //public static final By leave_title = By.xpath("//h6[text()='Leave']");
    public static final By leave_Apply = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a");
    public static final By leave_comment_text = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div/div/div[1]/label");
    public static final By leave_comment = By.xpath("//textarea[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]");




    public leave(WebDriver driver){
        this.driver = driver;
        driver.findElement(leave_button).click();


    }
    //public void setLeave_comment(String comment) {
        //driver.findElement(leave_comment).sendKeys(comment);


   // }
    public void leave_Apply() {
        driver.findElement(leave_Apply).click();


    }
}
