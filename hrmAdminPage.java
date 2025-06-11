package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hrmAdminPage {
    public static WebDriver driver;
    private static final By usernameField = By.name("username");
    private static final By passwordField = By.name("password");
    private static final By loginButton = By.xpath("//button[@type='submit']");

    private static final By itemAdmin = By.xpath("//*[contains(@class,'oxd-sidepanel-body')]/child::ul[contains(@class,'oxd-main-menu')]/li[1]"); //1
    private static final By itemPim = By.xpath("//*[contains(@class,'oxd-sidepanel-body')]/child::ul[contains(@class,'oxd-main-menu')]/li[2]"); //2
    private static final By itemLeave = By.xpath("//*[contains(@class,'oxd-sidepanel-body')]/child::ul[contains(@class,'oxd-main-menu')]/li[3]");//3
    private static final By adminMenu = By.xpath("//span[text()='Admin']");
    private static final By pimMenu = By.xpath("//span[text()='PIM']");
    private static final By leaveMenu = By.xpath("//span[text()='Leave']");

    private static final By usernameInput = By.xpath("//*[text()='Username']/following::input[@class='oxd-input oxd-input--active'][1]");//4
    private static final By dropDownUserRole = By.xpath("//*[text()='User Role']/following::div[@class='oxd-select-wrapper'][1]");//5
    private static final By adminRole= By.xpath("//div[contains(@class,'oxd-select-dropdown')]//div[text()='Admin']");//6
    private static final By ESSRole= By.xpath("//div[contains(@class,'oxd-select-dropdown')]//div[text()='ESS']");//7
    private static final By inputEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");//8
    private static final By btnReset = By.xpath("//button[normalize-space()='Reset']");//9
    private static final By btnSearch = By.xpath("//button[normalize-space()='Search']");//10
    private static final By getUserManagementMenu = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item' and contains(text(),'User Management')]");//11
    private static final By dataUser = By.xpath("(//*[contains(@role,'cell')])[2]");//12
    private static final By dataUserRole = By.xpath("(//*[contains(@role,'cell')])[3]");//13
    private static final By editButton = By.xpath("((//*[contains(@class,'oxd-table-cell-actions')])[1]//following::button[contains(@class,'oxd-icon-button oxd-table-cell-action-space')][1])[2]");//14
    private static final By deleteButton = By.xpath("((//*[contains(@class,'oxd-table-cell-actions')])[1]//following::button[contains(@class,'oxd-icon-button oxd-table-cell-action-space')][1])[1]");//15
    private static final By userHeader = By.xpath("(//*[contains(@role,'columnheader')])[3]");//16
    private static final By employeeHeader = By.xpath("(//*[contains(@role,'columnheader')])[4]");//17
    private static final By getUserManagementBar = By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-level') and text()='User Management']");//18
    private static final By closeButton = By.xpath("//button[contains(@class, 'oxd-main-menu-button')]");//19
    private static final By closePopup = By.xpath("//button[@class='oxd-icon-button' and .//i[contains(@class, 'bi-caret-up-fill')]]");//20
    private static final By addButton = By.xpath("(//*[contains(@type,'button')])[6]");//21

    public static void main(String[] args) {
        setupBrowser();
        login("Admin", "admin123");
        driver.findElement(itemAdmin).click();
        System.out.println("Tiêu đề sau khi đăng nhập: " + driver.getTitle());
        driver.quit();
    }

    private static void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        sleep(3000);
    }

    private static void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        sleep(3000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

