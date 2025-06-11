package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class airbnbHomePage {
    public static WebDriver driver;

    private static final By logo = By.xpath("//a[contains(@class, 'flex') and contains(., 'airbnb')]"); //1
    private static final By homeNav = By.xpath("//a[text()='Home']"); //2
    private static final By aboutNav = By.xpath("//a[text()='About']"); //3
    private static final By servicesNav = By.xpath("//a[text()='Services']");
    private static final By pricingNav = By.xpath("//a[text()='Pricing']");
    private static final By contactNav = By.xpath("//a[text()='Contact']");
    private static final By profileButton = By.xpath("//button[img[@src='https://cdn-icons-png.flaticon.com/512/6596/6596121.png']]"); //4

    private static final By searchLocation = By.xpath("//div[p[text()='Địa điểm'] and p[text()='Bạn sắp đi đâu?']]"); //5
    private static final By searchDate = By.xpath("//div[contains(@class,'grid-cols-12')]/div[3]"); //6
    private static final By searchGuest = By.xpath("//div[contains(@class,'col-span-3 flex-1 p-3 flex')]"); //7
    private static final By btnPlus = By.xpath("//button[contains(@class, 'font-bold') and div[text()='+']]"); //8
    private static final By btnMinus = By.xpath("//button[contains(@class, 'font-bold') and div[text()='-']]"); //9

    private static final By cardHCM = By.xpath("//h2[text()='Hồ Chí Minh']/ancestor::div[contains(@class, 'ant-card')]"); //10
    private static final By cardCanTho = By.xpath("//h2[text()='Cần Thơ']"); //11
    private static final By typeFilter = By.xpath("//*[contains(text(),'Loại nơi ở')]"); //12
    private static final By priceFilter = By.xpath("//*[contains(text(),'Giá')]"); //13
    private static final By footerLink = By.xpath("//*[@id='root']//a[3]//p"); //14

    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo4.cybersoft.edu.vn/");
        System.out.println("Tiêu đề sau khi đăng nhập: " + driver.getTitle());
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        setup();
        try {
            Thread.sleep(2000); // Giữ trang hiển thị 2s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
    }
}
