package pages;

import org.openqa.selenium.WebDriver;

import static pages.DashBoardLocators.ADMIN_MENU_ITEM;

public class AdminPage {
    protected WebDriver driver;


    public AdminPage(WebDriver driver){
        this.driver = driver;
        this.driver.findElement(DashBoardLocators.ADMIN_MENU_ITEM).click();
    }
    public void editJobTitle(){
        this.driver.findElement(AdminPageLocators.ADMIN_CORPORATE_BRANDING_DROP_DOWN_LIST).click();

    }


}
