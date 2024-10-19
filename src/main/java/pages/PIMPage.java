package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {
    protected WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private static final By EMPLOYEE_NAME_INPUT = By.cssSelector("input[name='employeeName']");
    private static final By EMPLOYEE_ID_INPUT = By.cssSelector("input[name='employeeId']");
    private static final By SEARCH_ID_INPUT = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input");
    private static final By PIM_MENU = By.cssSelector("div.oxd-menu-wrapper");
    private static final By ADD_EMPLOYEE_LINK = By.cssSelector("a.oxd-topbar-body-nav-tab-item");
    private static final By ADD_EMPLOYEE_BUTTON = By.cssSelector("button.oxd-button.oxd-button--primary");
    private static final By SAVE_BUTTON = By.cssSelector("button.oxd-button.oxd-button--secondary");
    private static final By SEARCH_BUTTON = By.className("oxd-button--secondary");
    private static final By PAGE_LOAD_INDICATOR = By.cssSelector("div.some-indicator-element");
    private static final By RESET_BUTTON = By.cssSelector("button.oxd-button--ghost");
    private static final By EMPLOYEE_DROPDOWN = By.cssSelector("div.oxd-select-text--active");
    private static final By EMPLOYEE_DROPDOWN_OPTIONS = By.cssSelector("div.oxd-select-text-input"); // Adjust if necessary
    private static final By EMPLOYEE_DROPDOWN_OPTION_CURRENT = By.xpath("//div[text()='Current Employees Only']");
    private static final By EMPLOYEE_STATUS_DROPDOWN = By.cssSelector("div.oxd-select-text-input");
    private static final By EMPLOYEE_STATUS_OPTIONS = By.cssSelector("div.oxd-select-dropdown");


    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased timeout
        waitForPageLoad(); // Ensure the page is fully loaded
        clickPIMMenu(); // Click the PIM menu after the page loads
    }

    // Wait for a specific element indicating the page has fully loaded
    private void waitForPageLoad() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOAD_INDICATOR));
        } catch (TimeoutException e) {
            System.out.println("Page did not load within the timeout period.");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            // Optionally, take a screenshot for debugging
        }
    }
    public void clickEmployeeDropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(EMPLOYEE_DROPDOWN));
        dropdown.click();
    }

    // Select an option from the Employee dropdown
    public void selectEmployeeOption(String optionText) {
        clickEmployeeDropdown(); // Open the dropdown

        // Wait for the dropdown options to be visible
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + optionText + "']")));
        option.click(); // Click the desired option
    }

    // Optionally, add a method to get the currently selected option
    public String getSelectedEmployeeOption() {
        WebElement selectedOption = wait.until(ExpectedConditions.visibilityOfElementLocated(EMPLOYEE_DROPDOWN_OPTIONS));
        return selectedOption.getText(); // Return the text of the currently selected option
    }

    // Click the PIM menu
    private void clickPIMMenu() {
        try {
            WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(DashBoardLocators.PIM_MENU_ITEM));
            pimMenu.click();
        } catch (TimeoutException e) {
            System.out.println("Failed to click PIM Menu: " + e.getMessage());
            System.out.println("Current URL: " + driver.getCurrentUrl());
        }
    }

    // Click the Add Employee button
    public void clickAddEmployeeButton() {
        WebElement addEmployeeButton = wait.until(ExpectedConditions.elementToBeClickable(ADD_EMPLOYEE_BUTTON));
        addEmployeeButton.click();
    }
    public void clickResetButton() {
        WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(RESET_BUTTON));
        resetButton.click();
    }
    public String getEmployeeIdInputValue() {
        WebElement employeeIdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(EMPLOYEE_ID_INPUT));
        return employeeIdInput.getAttribute("value");
    }

    // Fill in employee details
    public void fillEmployeeDetails(String name, String id) {
        WebElement employeeNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(EMPLOYEE_NAME_INPUT));
        employeeNameInput.clear();  // Clear any pre-filled value
        employeeNameInput.sendKeys(name);

        WebElement employeeIdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(EMPLOYEE_ID_INPUT));
        employeeIdInput.clear();  // Clear any pre-filled value
        employeeIdInput.sendKeys(id);
    }

    // Click the Save button
    public void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(SAVE_BUTTON));
        saveButton.click();
    }

    // Add a new employee
    public void addNewEmployee(String name, String id) {
        clickAddEmployeeButton();
        fillEmployeeDetails(name, id);
        clickSaveButton();
    }

    // Search for an employee by ID
    public void navigateToAddEmployee() {
        WebElement addEmployeeLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.oxd-topbar-body-nav-tab-item"))); // Adjust the selector as necessary
        addEmployeeLink.click();
    }
    public void clickEmployeeStatusDropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(EMPLOYEE_STATUS_DROPDOWN));
        dropdown.click();
    }
    public void selectEmployeeStatus(String status) {
        clickEmployeeStatusDropdown();
        // Wait for options to be visible
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + status + "']"))); // Update this as necessary
        option.click();
    }

    // Get the selected employee status value
    public String getSelectedEmployeeStatus() {
        WebElement selectedStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(EMPLOYEE_STATUS_DROPDOWN));
        return selectedStatus.getText();
    }

    // Change the employee status to a new option
    public void changeEmployeeStatus(String newStatus) {
        selectEmployeeStatus(newStatus); // Select the new status
    }
    public void searchByEmployeeId(String employeeId) {
        WebElement searchIdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_ID_INPUT));
        searchIdInput.clear();  // Clear any pre-filled value
        searchIdInput.sendKeys(employeeId);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
        searchButton.click();
    }
}
