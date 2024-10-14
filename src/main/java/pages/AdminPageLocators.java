package pages;

import org.openqa.selenium.By;

public class AdminPageLocators {
    public static final By ADMIN_PAGE_TITLE = By.className("oxd-topbar-header-title");
    public static final By ADMIN_CORPORATE_BRANDING_DROP_DOWN_LIST =By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-item') and contains(text(), 'Corporate Branding')]");
    public static final By ADMIN_PRIMARY_COLOR=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div[1]");
        public static final By USER_MANAGEMENT_DROP_DOWN_LIST=By.xpath("//span[contains(text(),'User Management')]");

}
