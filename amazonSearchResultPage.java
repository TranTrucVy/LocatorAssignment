package org.example;
import com.twocaptcha.captcha.Normal;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.sleep;
import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.AmazonWaf;

import java.util.Base64;

public class amazonSearchResultPage {
    public static WebDriver driver;
    private static final By shoeImage  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/span/div/div/div[2]");//1
    private static final By listPrice  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/span/div/div/div[3]/div[3]/div/div[1]/a/div");//2
    private static final By price  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/span/div/div/div[3]/div[3]/div/div[1]/a/span[1]");//3
    private static final By searchInput  = By.xpath("//input[@id='twotabsearchtextbox']");//4
    private static final By shoppingCart  = By.xpath("//a[@id='nav-cart']");//5
    private static final By fullCard  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/div/div/div/div/div/div/span/div/div[1]/div/div/div/div/ol/li[2]/div/div/div");//6
    //7 không có
    private static final By nameCard  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/span/div/div/div[3]/div[1]/a/h2/span");//8
    private static final By deliveryDate  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div[3]/div[4]/div[1]");//9
    private static final By typeAdidas  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/span/div/div/div[2]/div[1]/div/h2");//10
    private static final By shoptopCollection  = By.xpath("//h2[@id='loom-desktop-top-slot_us-slds-sp-2-t1-a2-heading']");//11
    private static final By iconCheckbox  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[2]/ul/span/span[1]/li/span/a/div/label/i");//12
    private static final By textResults  = By.xpath("/html/body/div[1]/div[1]/span/div/h1/div/div[1]/div/h2/span[1]");//13
    private static final By textTopItem  = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/span/div/div[1]/div/div/div/div/ol/li[5]/div/div/div/div[2]/div");//14

    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void searchAdidas() {
        driver.get("https://www.amazon.com/");
        driver.findElement(searchInput).sendKeys("adidas");
        driver.findElement(searchInput).submit();
        WebElement resultText = driver.findElement(textResults);
        System.out.println("Kết quả tìm kiếm: " + resultText.getText());
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        setup();
        searchAdidas();
        try {
            sleep(4000); // đợi load trang
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
    }
}
