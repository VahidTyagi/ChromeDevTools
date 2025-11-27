package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBase {

    public static WebDriver driver;

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void tearDown() {
        driver.quit();
    }
}
