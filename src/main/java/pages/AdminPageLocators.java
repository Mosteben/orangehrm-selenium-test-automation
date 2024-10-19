package pages;

import org.openqa.selenium.By;

public class AdminPageLocators {
    public static final By ADMIN_IDLE = By.cssSelector("h6.oxd-text.oxd-text--h6.orangehrm-main-title");
    public static final By ADMIN_CORPORATE_BRANDING_DROP_DOWN_LIST =By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-item') and contains(text(), 'Corporate Branding')]");
    public static final By ADMIN_PRIMARY_COLOR=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    public static final By ADMIN_PRIMARY_COLOR_HEX=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/input[2]");
    public static final By ADMIN_CLIENT_LOGO=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div/div[2]/input");


}
